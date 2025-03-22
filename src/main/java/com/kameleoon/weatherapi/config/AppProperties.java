package com.kameleoon.weatherapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openweathermap")
public class AppProperties {

    private Integer limit;

    private String apiKey;

    private Duration expiredTime;
}
