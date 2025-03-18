package com.kameleoon.weatherapi.facade;

import com.kameleoon.weatherapi.config.OpenWeatherMapProperties;
import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.dto.WeatherReportDto;
import com.kameleoon.weatherapi.exception.CustomException;
import com.kameleoon.weatherapi.feign.ExternalWeatherApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class
WeatherReportFacadeImpl implements WeatherReportFacade {

    private final ExternalWeatherApi externalWeatherApi;

    private final OpenWeatherMapProperties openWeatherMapProperties;

//    @Value("${openweathermap.limit:1}")
//    private Integer limit;
//
//    @Value("${openweathermap.api-key}")
//    private String apiKey;

    @Override
    public WeatherReportDto getWeatherReport(String cityInfo) {
        if (cityInfo == null || cityInfo.trim().isEmpty()) {
            throw new CustomException("City Info can't be empty", HttpStatus.BAD_REQUEST, ExternalWeatherApi.class,
                    "getWeatherReport");
        }

        CityInfoDto cityInfoDto = getCityInfo(cityInfo);

        log.info("CityInfoDto:===========> {}", cityInfoDto);

        try {
            WeatherReportDto weatherReportDto = externalWeatherApi.getExternalWeather(cityInfo, cityInfoDto.getLatitude(),
                    cityInfoDto.getLongitude(), openWeatherMapProperties.getApiKey());
            return weatherReportDto;
        } catch (Exception e) {
            log.error("Error while getting weather report for the city {}", cityInfo, e);
            throw new CustomException("Internal service error", HttpStatus.INTERNAL_SERVER_ERROR,
                    ExternalWeatherApi.class, "getWeatherReport", e);
        }
    }

    public CityInfoDto getCityInfo(String cityInfo) {
        try {
            return externalWeatherApi.getCityInfo(cityInfo, openWeatherMapProperties.getLimit(),
                    openWeatherMapProperties.getApiKey()).getFirst();
        } catch (Exception e) {
            log.error("Error while getting city info for the city {}", cityInfo, e);
            throw new CustomException("Internal service error", HttpStatus.INTERNAL_SERVER_ERROR,
                    ExternalWeatherApi.class, "getCityInfo", e);
        }
    }
}
