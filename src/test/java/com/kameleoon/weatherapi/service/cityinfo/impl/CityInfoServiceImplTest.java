package com.kameleoon.weatherapi.service.cityinfo.impl;

import com.kameleoon.weatherapi.IntegrationTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CityInfoServiceImplTest extends IntegrationTestBase {

    @InjectMocks
    protected CityInfoServiceImpl cityInfoServiceImpl;

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void getCityName_givenCityInfo_returnsCityName() {
        String cityNameOne = cityInfoServiceImpl.getCityName("London, GB");
        assertEquals("London", cityNameOne);

        String cityNameTwo = cityInfoServiceImpl.getCityName("New York,NY,US");
        assertEquals("New York", cityNameTwo);
    }
}
