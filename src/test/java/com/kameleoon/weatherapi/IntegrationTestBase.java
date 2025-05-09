package com.kameleoon.weatherapi;

import com.kameleoon.weatherapi.config.AppProperties;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

public abstract class IntegrationTestBase {

    protected AppProperties appProperties;

    @BeforeEach
    protected void setUp() {
        appProperties = new AppProperties();
        appProperties.setLimit(1);
        appProperties.setApiKey("test-key");
        appProperties.setExpiredTime(Duration.ofMinutes(10));
    }
}
