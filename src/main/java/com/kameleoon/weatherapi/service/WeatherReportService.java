package com.kameleoon.weatherapi.service;

import com.kameleoon.weatherapi.entity.WeatherReport;

import java.util.List;

public interface WeatherReportService {

    boolean notExpired(WeatherReport weatherReport);

    WeatherReport getWeatherReportByCityName(String cityName);

    List<WeatherReport> getAllWeatherReports();

    void deleteWeatherReport(WeatherReport weatherReport);
}
