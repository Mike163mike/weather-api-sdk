package com.kameleoon.weatherapi.feign;

import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.dto.WeatherReportDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "ExternalWeatherApi",
        url = "http://api.openweathermap.org/geo/1.0/direct")
public interface ExternalWeatherApi {

    @GetMapping
    CityInfoDto getCityInfo(
            @RequestParam(value = "q") String cityInfo,
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "appid") String apiKey
    );


    @GetMapping
    WeatherReportDto getExternalWeather(
            @RequestParam(value = "q") String city_info,
            @RequestParam(value = "lat") Double latitude,
            @RequestParam(value = "lon") Double longitude,
            @RequestParam(value = "appid") String apiKey
    );
}
