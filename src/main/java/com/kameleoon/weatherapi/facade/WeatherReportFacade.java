package com.kameleoon.weatherapi.facade;

import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.dto.WeatherReportDto;
import org.springframework.http.ResponseEntity;

public interface WeatherReportFacade {

    CityInfoDto getCityInfo(String cityInfo);

    ResponseEntity<WeatherReportDto> getWeatherReport(String cityInfo);
}
