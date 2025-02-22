package com.kameleoon.weatherapi.mapper;

import com.kameleoon.weatherapi.dto.WeatherReportDto;
import com.kameleoon.weatherapi.entity.WeatherReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WeatherReportMapper {

    @Mapping(target = "weather", source = "weather")
    @Mapping(target = "temperature", source = "temperature")
    @Mapping(target = "wind", source = "wind")
    @Mapping(target = "sys", source = "sys")
    @Mapping(target = "visibility", source = "visibility")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "timeZone", source = "timeZone")
    @Mapping(target = "name", source = "name")
    WeatherReportDto toDto(WeatherReport weatherReport);

    @Mapping(target = "cityInfo", ignore = true)
    @Mapping(target = "weather", source = "weather")
    @Mapping(target = "temperature", source = "temperature")
    @Mapping(target = "wind", source = "wind")
    @Mapping(target = "sys", source = "sys")
    @Mapping(target = "visibility", source = "visibility")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "timeZone", source = "timeZone")
    @Mapping(target = "name", source = "name")
    WeatherReport toEntity(WeatherReportDto weatherReportDto);

    @Mapping(target = "main", source = "main")
    @Mapping(target = "description", source = "description")
    WeatherReport.Weather toWeatherEntity(WeatherReportDto.Weather weather);

    @Mapping(target = "temp", source = "temp")
    @Mapping(target = "feelsLike", source = "feelsLike")
    WeatherReport.Temperature toTemperatureEntity(WeatherReportDto.Temperature temperature);

    @Mapping(target = "speed", source = "speed")
    WeatherReport.Wind toWindEntity(WeatherReportDto.Wind wind);

    @Mapping(target = "sunrise", source = "sunrise")
    @Mapping(target = "sunset", source = "sunset")
    WeatherReport.Sys toSys(WeatherReportDto.Sys sys);

    @Mapping(target = "main", source = "main")
    @Mapping(target = "description", source = "description")
    WeatherReportDto.Weather toWeatherDto(WeatherReport.Weather weather);

    @Mapping(target = "temp", source = "temp")
    @Mapping(target = "feelsLike", source = "feelsLike")
    WeatherReportDto.Temperature toTemperatureDto(WeatherReport.Temperature temperature);

    @Mapping(target = "speed", source = "speed")
    WeatherReportDto.Wind toWindDto(WeatherReport.Wind wind);

    @Mapping(target = "sunrise", source = "sunrise")
    @Mapping(target = "sunset", source = "sunset")
    WeatherReportDto.Sys toSysDto(WeatherReport.Sys sys);
}
