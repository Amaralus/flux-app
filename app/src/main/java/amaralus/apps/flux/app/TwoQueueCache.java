package amaralus.apps.flux.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.requireNonNull;

public class TwoQueueCache<K, V> {

    private final Map<K, CacheElement<V>> map;
    private final LinkedList<K> in = new LinkedList<>();
    private final CacheQueue out;
    private final CacheQueue lru;

    private final int inMaxSize;

    private AtomicLong hitCount;
    private AtomicLong missCount;

    public TwoQueueCache(int size) {
        map = new HashMap<>(size);
        inMaxSize = (int) (size * .25f);
        out = new CacheQueue(size - (inMaxSize * 2));
        lru = new CacheQueue(inMaxSize);
    }

    public V get(K key) {
        requireNonNull(key);

        synchronized (this) {
            var element = map.get(key);
            if (element != null) {
                hitCount.incrementAndGet();

                if (element.location == Location.OUT)
                    moveOutToLru(key, element);
                else if (element.location == Location.LRU)
                    warmUp(key);

                return element.cachedValue;
            }
        }

        missCount.incrementAndGet();

        return null;
    }

    public V put(K key, V value) {
        requireNonNull(key);
        requireNonNull(value);

        synchronized (this) {
            var element = map.get(key);
            if (element != null) {
                V prev = element.cachedValue;
                element.cachedValue = value;
                return prev;
            }
        }

        var element = new CacheElement<>(value, Location.IN);
        synchronized (this) {
            map.put(key, element);
            in.addFirst(key);

            if (in.size() > inMaxSize) {
                var last = in.removeLast();
                map.get(last).location = Location.OUT;
                out.put(last);
            }
        }

        return null;
    }

    public V remove(K key) {
        requireNonNull(key);

        synchronized (this) {
            var element = map.remove(key);
            if (element != null) {
                switch (element.location) {
                    case IN:
                        in.remove(key);
                        break;
                    case OUT:
                        out.remove(key);
                        break;
                    case LRU:
                        lru.remove(key);
                        break;
                }

                return element.cachedValue;
            }
        }

        return null;
    }

    private void moveOutToLru(K key, CacheElement<V> element) {
        out.remove(key);
        element.location = Location.LRU;
        lru.put(key);
    }

    private void warmUp(K key) {
        lru.warmUp(key);
    }

    public long getHitCount() {
        return hitCount.get();
    }

    public long getMissCount() {
        return missCount.get();
    }

    private static class CacheElement<V> {
        V cachedValue;
        Location location;

        public CacheElement(V cachedValue, Location location) {
            this.cachedValue = cachedValue;
            this.location = location;
        }
    }

    private enum Location {IN, OUT, LRU}

    private class CacheQueue extends LinkedHashMap<K, Object> {
        final int maxSize;
        final transient Object stub = new Object();

        CacheQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, Object> eldest) {
            var remove = size() > maxSize;
            if (remove)
                map.remove(eldest.getKey());
            return remove;
        }

        public void put(K key) {
            super.put(key, stub);
        }

        public void warmUp(K key) {
            super.remove(key);
            put(key);
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}
