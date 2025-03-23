package com.kameleoon.weatherapi.conrtroller;

import com.kameleoon.weatherapi.dto.weatherreport.WeatherResponseDto;
import com.kameleoon.weatherapi.facade.WeatherReportFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-report")
@AllArgsConstructor
@Validated
public class WeatherReportController {

    private final WeatherReportFacade weatherReportFacade;

    @GetMapping("/on-demand")
    @Operation(summary = "Get weather report on demand",
            description = "Fetches the current weather report for a given city.")
    public ResponseEntity<WeatherResponseDto> onDemand(
            @RequestParam
            @Pattern(regexp = "^[a-zA-Z\\s]+(,\\s?[a-zA-Z]{2})?(,\\s?[a-zA-Z]{2,3})?$", message = "Invalid city info format")
            @Schema(name = "cityInfo",
                    description = """
                            City information: The string has three parts separated by commas. The first part is the city name,
                            the second part is the state code (for the US only), and the third part is the country code.
                            We recommend using ISO 3166 country codes. Only the first part of the string is required, while the
                            other parts can be empty strings.
                            """,
                    example = "London,GB")
            String cityInfo) {
        return ResponseEntity.ok(weatherReportFacade.getWeatherReport(cityInfo));
    }
}
