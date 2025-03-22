package com.kameleoon.weatherapi.facade;

import com.kameleoon.weatherapi.dto.cityinfo.CityInfoDto;
import com.kameleoon.weatherapi.dto.weatherreport.WeatherResponseDto;
import com.kameleoon.weatherapi.entity.CityInfo;

public interface WeatherReportFacade {

    CityInfoDto getCityInfoDto(String cityInfo);

    WeatherResponseDto getWeatherReport(String cityInfo);

    WeatherResponseDto getWeatherResponseDto(CityInfo cityInfo);
}
