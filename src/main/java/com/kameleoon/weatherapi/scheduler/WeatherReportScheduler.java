package com.kameleoon.weatherapi.scheduler;

import com.kameleoon.weatherapi.facade.WeatherReportFacade;
import com.kameleoon.weatherapi.service.cityinfo.CityInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherReportScheduler {

    private final WeatherReportFacade weatherReportFacade;

    private final CityInfoService cityInfoService;

    @Scheduled(fixedRateString = "${openweathermap.expired-time}")
    public void getWeatherReport() {
        cityInfoService.getAllCityInfo()
                .forEach(cityInfo -> {
                    weatherReportFacade.getWeatherReport(cityInfo.getName());
                });
    }
}
