package amaralus.apps.flux.app.controller;

import amaralus.apps.flux.app.model.Alpha;
import amaralus.apps.flux.app.service.AlphaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("alpha")
@RequiredArgsConstructor
@Slf4j
public class AlphaController {

    private final AlphaService alphaService;

    @GetMapping("{count}")
    public Flux<Alpha> getMany(@PathVariable int count) {
        log.info("alpha count");
        return alphaService.byCount(count);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Mono<Alpha> getAlpha() {
        log.info("get Alpha");
        return Mono.just(new Alpha("alpha"));
    }

    @GetMapping("/proxy")
    public Mono<Alpha> getAlphaOverProxy() {
        log.info("over proxy");
        return alphaService.overProxy();
    }
}
