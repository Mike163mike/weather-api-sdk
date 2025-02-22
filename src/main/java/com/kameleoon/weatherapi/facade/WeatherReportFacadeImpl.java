package com.kameleoon.weatherapi.facade;

import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.dto.WeatherReportDto;
import com.kameleoon.weatherapi.exception.ResponseException;
import com.kameleoon.weatherapi.feign.ExternalWeatherApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WeatherReportFacadeImpl implements WeatherReportFacade {

    private final ExternalWeatherApi externalWeatherApi;

    @Value("${openweathermap.limit:1}")
    private Integer limit;

    @Value("${openweathermap.api-key}")
    private String apiKey;

    @Override
    public ResponseEntity<WeatherReportDto> getWeatherReport(String cityInfo) {
        if (cityInfo == null || cityInfo.trim().isEmpty()) {
            throw new ResponseException("City Info can't be empty", HttpStatus.BAD_REQUEST, ExternalWeatherApi.class,
                    "getWeatherReport");
        }

        CityInfoDto cityInfoDto = getCityInfo(cityInfo);

        try {
            WeatherReportDto weatherReportDto = externalWeatherApi.getExternalWeather(cityInfo, cityInfoDto.getLatitude(),
                    cityInfoDto.getLongitude(), apiKey);
            return ResponseEntity.ok(weatherReportDto);
        } catch (Exception e) {
            log.error("Error while getting weather report for the city {}", cityInfo, e);
            throw new ResponseException("Internal service error", HttpStatus.INTERNAL_SERVER_ERROR,
                    ExternalWeatherApi.class, "getWeatherReport", e);
        }
    }

    public CityInfoDto getCityInfo(String cityInfo) {
        try {
            return externalWeatherApi.getCityInfo(cityInfo, limit, apiKey);
        } catch (Exception e) {
            log.error("Error while getting city info for the city {}", cityInfo, e);
            throw new ResponseException("Internal service error", HttpStatus.INTERNAL_SERVER_ERROR,
                    ExternalWeatherApi.class, "getCityInfo", e);
        }
    }
}
