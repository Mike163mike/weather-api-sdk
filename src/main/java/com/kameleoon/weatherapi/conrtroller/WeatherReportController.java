package com.kameleoon.weatherapi.conrtroller;

import com.kameleoon.weatherapi.dto.WeatherReportDto;
import com.kameleoon.weatherapi.facade.WeatherReportFacade;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-report")
@AllArgsConstructor
public class WeatherReportController {

    private final WeatherReportFacade weatherReportFacade;

    @GetMapping("/on-demand")
    public ResponseEntity<WeatherReportDto> onDemand(
            @RequestParam
            @Pattern(regexp = "^[a-zA-Z\\s]+(,\\s?[a-zA-Z]{2})?(,\\s?[a-zA-Z]{2,3})?$", message = "Invalid city info format")
            String cityInfo) {
        return weatherReportFacade.getWeatherReport(cityInfo);
    }
}
