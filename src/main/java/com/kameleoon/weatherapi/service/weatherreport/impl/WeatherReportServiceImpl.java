package com.kameleoon.weatherapi.service.weatherreport.impl;

import com.kameleoon.weatherapi.config.AppProperties;
import com.kameleoon.weatherapi.entity.WeatherReport;
import com.kameleoon.weatherapi.repository.WeatherReportRepository;
import com.kameleoon.weatherapi.service.WeatherReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherReportServiceImpl implements WeatherReportService {

    private final AppProperties appProperties;

    private final WeatherReportRepository weatherReportRepository;

    @Override
    public boolean notExpired(WeatherReport weatherReport) {
        return weatherReport.getCreateDate().isAfter(OffsetDateTime.now().minus(appProperties
                .getExpiredTime()));
    }

    @Override
    public WeatherReport getWeatherReportByCityName(String cityName) {
        return weatherReportRepository.findByCityName(cityName);
    }

    @Override
    public List<WeatherReport> getAllWeatherReports() {
        return weatherReportRepository.findAll();
    }

    @Override
    public void deleteWeatherReport(WeatherReport weatherReport) {
        weatherReportRepository.delete(weatherReport);
    }
}
