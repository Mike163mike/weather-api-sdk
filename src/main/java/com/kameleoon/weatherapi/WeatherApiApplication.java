package com.kameleoon.weatherapi;

import com.kameleoon.weatherapi.config.OpenWeatherMapProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@OpenAPIDefinition
@EnableFeignClients
@EnableConfigurationProperties(OpenWeatherMapProperties.class)
public class WeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApplication.class, args);
    }
}
