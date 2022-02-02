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

@RestController
@RequestMapping("alpha")
@RequiredArgsConstructor
@Slf4j
public class AlphaController {

    private final AlphaService alphaService;

    @GetMapping("{count}")
    public Flux<Alpha> getMany(@PathVariable int count) {
        return alphaService.byCount(count);
    }
}
