package com.fsdp0.spring_mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
            new Info().title("Spring Data MongoDB")
                        .description("Spring Boot MongoDB Demo Application")
                        .version("0.0.1")
        );
    }
}
