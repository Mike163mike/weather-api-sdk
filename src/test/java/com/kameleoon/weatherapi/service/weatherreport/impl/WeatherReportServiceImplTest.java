package com.kameleoon.weatherapi.service.weatherreport.impl;

import com.kameleoon.weatherapi.IntegrationTestBase;
import com.kameleoon.weatherapi.entity.WeatherReport;
import com.kameleoon.weatherapi.repository.WeatherReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class WeatherReportServiceImplTest extends IntegrationTestBase {

    @Mock
    private WeatherReportRepository weatherReportRepository;

    @InjectMocks
    private WeatherReportServiceImpl weatherReportServiceImpl;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        weatherReportServiceImpl = new WeatherReportServiceImpl(appProperties, weatherReportRepository);
    }

    @Test
    void notExpired_givenNotExpiredDate_returnsTrue() {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCreateDate(OffsetDateTime.now().minusMinutes(5));
        boolean notExpired = weatherReportServiceImpl.notExpired(weatherReport);

        assertTrue(notExpired);
    }

    @Test
    void expired_givenExpiredDate_returnsFalse() {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCreateDate(OffsetDateTime.now().minusMinutes(15));
        boolean notExpired = weatherReportServiceImpl.notExpired(weatherReport);

        assertFalse(notExpired);
    }
}
