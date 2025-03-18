package com.kameleoon.weatherapi.facade;

import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.dto.WeatherReportDto;

public interface WeatherReportFacade {

    CityInfoDto getCityInfo(String cityInfo);

    WeatherReportDto getWeatherReport(String cityInfo);
}
