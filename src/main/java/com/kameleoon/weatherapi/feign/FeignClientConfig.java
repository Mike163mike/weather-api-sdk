package com.kameleoon.weatherapi.feign;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor loggingInterceptor() {
        return requestTemplate -> {
            System.out.println("Feign Request: " + requestTemplate.method() + " " + requestTemplate.url());
            requestTemplate.headers().forEach((key, value) ->
                    System.out.println("Header: " + key + " -> " + value));
            System.out.println("Request Body: " + requestTemplate.requestBody().asString());
        };
    }

    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(5000, 10000);
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
