package amaralus.apps.flux.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FluxApp {

    public static void main(String[] args) {
        SpringApplication.run(FluxApp.class);
    }
}
