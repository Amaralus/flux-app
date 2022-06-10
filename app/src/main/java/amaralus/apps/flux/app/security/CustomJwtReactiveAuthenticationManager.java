package amaralus.apps.flux.app.security;

import com.nimbusds.jose.shaded.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtReactiveAuthenticationManager;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class CustomJwtReactiveAuthenticationManager implements ReactiveAuthenticationManager {

    private final ReactiveJwtDecoder jwtDecoder;
    private final JwtReactiveAuthenticationManager jwtReactiveAuthenticationManager;

    public CustomJwtReactiveAuthenticationManager(ReactiveJwtDecoder jwtDecoder) {
        jwtReactiveAuthenticationManager = new JwtReactiveAuthenticationManager(jwtDecoder);
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        try {
            log.info("Custom auth");
            return jwtReactiveAuthenticationManager.authenticate(authentication)
                    .flatMap(returnAuth -> handle(returnAuth, authentication))
                    .doOnError(t -> log.error("custom auth do on error", t));
        } catch (Exception e) {
            log.error("Custom auth error", e);
            throw e;
        }
    }

    private Mono<Authentication> handle(Authentication returnAuth, Authentication authentication) {
        log.info("handling after authentication");
        var claims = Mono.just(authentication)
                .filter(BearerTokenAuthenticationToken.class::isInstance)
                .cast(BearerTokenAuthenticationToken.class)
                .map(BearerTokenAuthenticationToken::getToken)
                .flatMap(this.jwtDecoder::decode)
                .map(Jwt::getClaims)
                .toFuture().join();

        var username = claims.get("preferred_username");
        var roles = ((List<String>) ((JSONObject) claims.get("realm_access")).get("roles"));

        log.info("username {} roles {}", username, roles);

        return Mono.just(returnAuth);
    }
}
