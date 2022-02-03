package amaralus.apps.flux.app.service;

import amaralus.apps.flux.app.client.AlphaClient;
import amaralus.apps.flux.app.model.Alpha;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static java.util.Comparator.comparing;

@Service
@RequiredArgsConstructor
public class AlphaService {

    private final AlphaClient alphaClient;

    public Flux<Alpha> byCount(int count) {
        return Flux.fromIterable(Alpha.byCount(count))
                .parallel()
                .runOn(Schedulers.parallel())
                .map(this::alphaMap)
                .ordered(comparing(Alpha::getStr));
    }

    public Mono<Alpha> overProxy() {
        return alphaClient.getAlpha();
    }

    private Alpha alphaMap(Alpha alpha) {
        alpha.setStr("map " + alpha.getStr());
        return alpha;
    }
}
