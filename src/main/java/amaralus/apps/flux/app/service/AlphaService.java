package amaralus.apps.flux.app.service;

import amaralus.apps.flux.app.model.Alpha;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static java.util.Comparator.comparing;

@Service
public class AlphaService {

    public Flux<Alpha> byCount(int count) {
        return Flux.fromIterable(Alpha.byCount(count))
                .parallel()
                .runOn(Schedulers.parallel())
                .map(this::alphaMap)
                .ordered(comparing(Alpha::getStr));
    }

    private Alpha alphaMap (Alpha alpha) {
        alpha.setStr("map " + alpha.getStr());
        return alpha;
    }
}
