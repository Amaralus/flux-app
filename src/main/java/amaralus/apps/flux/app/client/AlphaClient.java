package amaralus.apps.flux.app.client;

import amaralus.apps.flux.app.model.Alpha;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlphaClient {

    private final WebClient.Builder webClient;

    public Mono<Alpha> getAlpha() {
        log.info("client");
        return webClient.build()
                .get()
                .uri("lb://flux-app2/alpha")
                .retrieve()
                .bodyToMono(Alpha.class);
    }
}
