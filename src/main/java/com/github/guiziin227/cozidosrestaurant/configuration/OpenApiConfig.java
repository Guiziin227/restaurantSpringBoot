package com.github.guiziin227.cozidosrestaurant.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Cozidos Restaurant API")
                        .version("1.0.0")
                        .description("API for managing Cozidos Restaurant operations, including products and waiters.")
        );
    }
}
