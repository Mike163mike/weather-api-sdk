package com.kameleoon.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kameleoon.weatherapi.entity.WeatherReport;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReportDto {

    @JsonProperty("weather")
    private WeatherReport.Weather weather;

    @JsonProperty("temperature")
    private WeatherReport.Temperature temperature;

    @JsonProperty("visibility")
    private Integer visibility;

    @JsonProperty("wind")
    private WeatherReport.Wind wind;

    @JsonProperty("datetime")
    private Long dateTime;

    @JsonProperty("sys")
    private WeatherReport.Sys sys;

    @JsonProperty("timezone")
    private Integer timeZone;

    @JsonProperty("name")
    private String name;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Weather {

        @JsonProperty("main")
        private String main;

        @JsonProperty("description")
        private String description;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Temperature {

        @JsonProperty("temp")
        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Wind {

        @JsonProperty("speed")
        private double speed;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Sys {

        @JsonProperty("sunrise")
        private Long sunrise;

        @JsonProperty("sunset")
        private Long sunset;
    }

    //    "weather":
//
//    {
//        "main":"Clouds",
//            "description":"scattered clouds",
//    },
//            "temperature":
//
//    {
//        "temp":269.6,
//            "feels_like":267.57,
//    },
//            "visibility":10000,
//            "wind":
//
//    {
//        "speed":1.38,
//    },
//            "datetime":1675744800,
//            "sys":
//
//    {
//        "sunrise":1675751262,
//            "sunset":1675787560
//    },
//            "timezone":3600,
//            "name":"Zocca",

//=====================================================
//    {
//        "coord": {
//        "lon": -0.1257,
//                "lat": 51.5085
//    },
//        "weather": [
//        {
//            "id": 803,
//                "main": "Clouds",
//                "description": "broken clouds",
//                "icon": "04d"
//        }
//    ],
//        "base": "stations",
//            "main": {
//        "temp": 283.83,
//                "feels_like": 283.33,
//                "temp_min": 282.88,
//                "temp_max": 284.82,
//                "pressure": 1011,
//                "humidity": 91,
//                "sea_level": 1011,
//                "grnd_level": 1007
//    },
//        "visibility": 10000,
//            "wind": {
//        "speed": 3.6,
//                "deg": 240
//    },
//        "clouds": {
//        "all": 75
//    },
//        "dt": 1740219699,
//            "sys": {
//        "type": 2,
//                "id": 2006068,
//                "country": "GB",
//                "sunrise": 1740207632,
//                "sunset": 1740245267
//    },
//        "timezone": 0,
//            "id": 2643743,
//            "name": "London",
//            "cod": 200
//    }
}
