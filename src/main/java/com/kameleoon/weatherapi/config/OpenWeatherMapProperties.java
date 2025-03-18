package com.kameleoon.weatherapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openweathermap")
public class OpenWeatherMapProperties {

    private Integer limit;

    private String apiKey;
}
