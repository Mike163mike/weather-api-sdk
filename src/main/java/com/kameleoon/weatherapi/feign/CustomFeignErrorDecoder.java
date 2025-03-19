package com.kameleoon.weatherapi.feign;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomFeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String errorMessage = response.body() != null ? Util.toString(response.body().asReader()) : "No response body";
            return new FeignException.FeignClientException(
                    response.status(),
                    errorMessage,
                    response.request(),
                    errorMessage.getBytes(StandardCharsets.UTF_8), // Тело ответа
                    response.headers() // Заголовки ответа
            );
        } catch (IOException e) {
            return new FeignException.FeignClientException(
                    response.status(),
                    "Feign error (unable to read response body)",
                    response.request(),
                    null, // Тело ответа (null, если нет данных)
                    response.headers() // Заголовки ответа
            );
        }
    }
}
