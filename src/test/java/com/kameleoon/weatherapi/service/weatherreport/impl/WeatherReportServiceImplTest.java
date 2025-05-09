package com.kameleoon.weatherapi.service.weatherreport.impl;

import com.kameleoon.weatherapi.config.AppProperties;
import com.kameleoon.weatherapi.entity.WeatherReport;
import com.kameleoon.weatherapi.service.WeatherReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.OffsetDateTime;

@ExtendWith(MockitoExtension.class)
class WeatherReportServiceImplTest {

    private AppProperties appProperties;

    @Spy
    private WeatherReportService weatherReportService;

    @BeforeEach
    void setUp() {
        appProperties = new AppProperties();
        appProperties.setLimit(1);
        appProperties.setApiKey("test-key");
        appProperties.setExpiredTime(Duration.ofMinutes(10));
    }

    @Test
    void notExpired_givenNotExpiredDate_returnsTrue() {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCreateDate(OffsetDateTime.now().minusMinutes(5));
        boolean notExpired = weatherReportService.notExpired(weatherReport);

        Assertions.assertTrue(notExpired);
    }

    @Test
    void notExpired_givenExpiredDate_returnsFalse() {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCreateDate(OffsetDateTime.now().minusMinutes(15));
        boolean notExpired = weatherReportService.notExpired(weatherReport);

        Assertions.assertFalse(notExpired);
    }
}