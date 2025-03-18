package com.kameleoon.weatherapi.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(
            @Value("${app.name}") String appName,
            @Value("${app.description}") String appDescription,
            @Value("${app.version}") String appVersion,
            @Value("${app.email}") String appEmail) {
        return new OpenAPI().info(new Info().title(appName)
                .version(appVersion)
                .description(appDescription)
                .license(new License().name("Apache 2.0")
                        .url("https://springdoc.org"))
                .contact(new Contact().name(appName)
                        .email(appEmail)));
    }
}
