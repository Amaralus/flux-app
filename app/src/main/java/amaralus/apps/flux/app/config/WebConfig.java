package amaralus.apps.flux.app.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder(
            /*ReactiveClientRegistrationRepository clientRegistrationRepo,
            ServerOAuth2AuthorizedClientRepository authorizedClientRepo*/) {

//        var filter = new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepo, authorizedClientRepo);

        return WebClient.builder();//.filter(filter);
    }
}
