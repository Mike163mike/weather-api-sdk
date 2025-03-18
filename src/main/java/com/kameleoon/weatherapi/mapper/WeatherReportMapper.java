package com.kameleoon.weatherapi.mapper;

import com.kameleoon.weatherapi.dto.WeatherReportDto;
import com.kameleoon.weatherapi.dto.WeatherResponseDto;
import com.kameleoon.weatherapi.entity.WeatherReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherReportMapper {

    @Mapping(source = "weather", target = "weather")
    @Mapping(source = "main.temp", target = "temperature.temp")
    @Mapping(source = "main.feelsLike", target = "temperature.feelsLike")
    @Mapping(source = "wind.speed", target = "wind.speed")
    @Mapping(source = "dateTime", target = "dateTime")
    @Mapping(source = "sys.sunrise", target = "sys.sunrise")
    @Mapping(source = "sys.sunset", target = "sys.sunset")
    @Mapping(source = "timeZone", target = "timeZone")
    @Mapping(source = "name", target = "name")
    WeatherReport toEntity(WeatherReportDto weatherReportDto);

    @Mapping(source = "weather", target = "weather")
    @Mapping(source = "temperature.temp", target = "temperature.temp")
    @Mapping(source = "temperature.feelsLike", target = "temperature.feelsLike")
    @Mapping(source = "wind.speed", target = "wind.speed")
    @Mapping(source = "dateTime", target = "dateTime")
    @Mapping(source = "sys.sunrise", target = "sys.sunrise")
    @Mapping(source = "sys.sunset", target = "sys.sunset")
    @Mapping(source = "timeZone", target = "timeZone")
    @Mapping(source = "name", target = "name")
    WeatherResponseDto toResponseDto(WeatherReport weatherReport);

    default WeatherReport.Weather mapWeather(List<WeatherReportDto.Weather> weatherList) {
        if (weatherList != null && !weatherList.isEmpty()) {
            return new WeatherReport.Weather(
                    weatherList.getFirst().getMain(),
                    weatherList.getFirst().getDescription()
            );
        }
        return null;
    }
}
