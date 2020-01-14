package com.github.brianmmcclain.ossscgdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OssScgDemoApplication {

    final String UI_REDIRECT = System.getenv("UI_DOMAIN");
    final String API_REDIRECT = System.getenv("API_DOMAIN");

	public static void main(final String[] args) {
        final String UI_REDIRECT = System.getenv("UI_DOMAIN");
        final String API_REDIRECT = System.getenv("API_DOMAIN");
        System.out.println(UI_REDIRECT);
        System.out.println(API_REDIRECT);
        SpringApplication.run(OssScgDemoApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(final RouteLocatorBuilder builder) {
        return builder.routes()
            .route("api", a -> a
                .path("/random")
                .uri(API_REDIRECT))
            .route("ui", p -> p
                .path("/**")
                .uri(UI_REDIRECT))
            .build();
    }

}
