package com.kameleoon.weatherapi.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CustomFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String errorMessage = "No response body";

        if (response.body() != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().asInputStream(),
                    StandardCharsets.UTF_8))) {
                errorMessage = reader.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                System.err.println("Error reading Feign response body: " + e.getMessage());
            }
        }

        return new FeignException.FeignClientException(
                response.status(),
                errorMessage,
                response.request(),
                errorMessage.getBytes(StandardCharsets.UTF_8), // Тело ответа
                response.headers()
        );
    }
}
