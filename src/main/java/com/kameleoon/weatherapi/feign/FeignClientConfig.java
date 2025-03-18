package com.kameleoon.weatherapi.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public Request.Options feignOptions() {
//        return new Request.Options(5000, 10000); // Таймауты (connectTimeout, readTimeout)
//    }
//
//    @Bean
//    public ErrorDecoder feignErrorDecoder() {
//        return new CustomFeignErrorDecoder(); // Ваш кастомный обработчик ошибок
//    }
}
