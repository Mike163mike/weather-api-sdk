package com.kameleoon.weatherapi.feign;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor loggingInterceptor() {
        return requestTemplate -> {
            log.info("Feign Request: {} {}", requestTemplate.method(), requestTemplate.url());
            requestTemplate.headers().forEach((key, value) -> log.info("Header: {} -> {}", key,
                    value));
            if (requestTemplate.body() != null) {
                log.info("Request Body: {}", new String(requestTemplate.body(), StandardCharsets.UTF_8));
            }
        };
    }

    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(5, TimeUnit.SECONDS, 10, TimeUnit.SECONDS,
                true);
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
