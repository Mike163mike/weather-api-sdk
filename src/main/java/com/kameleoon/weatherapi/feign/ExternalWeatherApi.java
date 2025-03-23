package com.kameleoon.weatherapi.feign;

import com.kameleoon.weatherapi.dto.cityinfo.CityInfoDto;
import com.kameleoon.weatherapi.dto.weatherreport.WeatherReportDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "ExternalWeatherApi",
        url = "https://api.openweathermap.org",
        configuration = FeignClientConfig.class)
public interface ExternalWeatherApi {

    @GetMapping("/geo/1.0/direct")
    List<CityInfoDto> getCityInfo(
            @RequestParam(value = "q") String cityInfo,
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "appid") String apiKey
    );

    @GetMapping("/data/2.5/weather")
    WeatherReportDto getExternalWeather(
            @RequestParam(value = "lat") Double latitude,
            @RequestParam(value = "lon") Double longitude,
            @RequestParam(value = "appid") String apiKey
    );
}
