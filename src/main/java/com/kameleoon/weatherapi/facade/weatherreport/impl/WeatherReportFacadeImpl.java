package com.kameleoon.weatherapi.facade.weatherreport.impl;

import com.kameleoon.weatherapi.config.AppProperties;
import com.kameleoon.weatherapi.dto.cityinfo.CityInfoDto;
import com.kameleoon.weatherapi.dto.weatherreport.WeatherReportDto;
import com.kameleoon.weatherapi.dto.weatherreport.WeatherResponseDto;
import com.kameleoon.weatherapi.entity.CityInfo;
import com.kameleoon.weatherapi.entity.WeatherReport;
import com.kameleoon.weatherapi.exception.CustomException;
import com.kameleoon.weatherapi.facade.WeatherReportFacade;
import com.kameleoon.weatherapi.feign.ExternalWeatherApi;
import com.kameleoon.weatherapi.mapper.CityInfoMapper;
import com.kameleoon.weatherapi.mapper.WeatherReportMapper;
import com.kameleoon.weatherapi.service.WeatherReportService;
import com.kameleoon.weatherapi.service.cityinfo.CityInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class WeatherReportFacadeImpl implements WeatherReportFacade {

    private final ExternalWeatherApi externalWeatherApi;

    private final AppProperties appProperties;

    private final WeatherReportService weatherReportService;

    private final CityInfoService cityInfoService;

    private final CityInfoMapper cityInfoMapper;

    private final WeatherReportMapper weatherReportMapper;

    @Override
    @Transactional
    public WeatherResponseDto getWeatherReport(String cityInfo) {
        if (cityInfo == null || cityInfo.trim().isEmpty()) {
            throw new CustomException("City Info can't be empty", HttpStatus.BAD_REQUEST, ExternalWeatherApi.class,
                    "getWeatherReport");
        }

        CityInfoDto cityInfoDto = getCityInfoDto(cityInfo);
        CityInfo savedCityInfo = cityInfoService.getCityInfoByName(cityInfoDto.getName());

        WeatherReport weatherReport = weatherReportService.getWeatherReportByCityName(cityInfoDto.getName());

        if (weatherReport != null && !weatherReportService.notExpired(weatherReport)) {
            weatherReportService.deleteWeatherReport(weatherReport);
        }
        return getWeatherResponseDto(savedCityInfo);
    }

    @Override
    public WeatherResponseDto getWeatherResponseDto(CityInfo cityInfo) {
        try {
            WeatherReportDto weatherReportDto = externalWeatherApi.getExternalWeather(
                    cityInfo.getLatitude(), cityInfo.getLongitude(), appProperties.getApiKey());

            cityInfo.setWeatherReport(weatherReportMapper.toEntity(weatherReportDto));
            cityInfoService.saveCityInfo(cityInfo);

            return weatherReportMapper.toResponseDto(weatherReportService.getWeatherReportByCityName(cityInfo.getName()));
        } catch (Exception e) {
            log.error("Error while getting weather report for the city {}", cityInfo.getName(), e);
            throw new CustomException("Internal service error while getting weather report for the city %s"
                    .formatted(cityInfo.getName()), HttpStatus.INTERNAL_SERVER_ERROR, ExternalWeatherApi.class,
                    "getWeatherReport", e);
        }
    }

    public CityInfoDto getCityInfoDto(String cityInfo) {
        String cityName = cityInfoService.getCityName(cityInfo);
        if (cityInfoService.existByName(cityName)) {
            return cityInfoMapper.toDto(cityInfoService.getCityInfoByName(cityName));
        }

        try {
            CityInfoDto cityInfoDto = externalWeatherApi.getCityInfo(cityInfo, appProperties.getLimit(),
                    appProperties.getApiKey()).getFirst();
            cityInfoService.saveCityInfo(cityInfoMapper.toEntity(cityInfoDto));
            return cityInfoDto;
        } catch (Exception e) {
            log.error("Error while getting city info for the city {}", cityInfo, e);
            throw new CustomException("Internal service error while getting city info for the city %s"
                    .formatted(cityInfo), HttpStatus.INTERNAL_SERVER_ERROR, ExternalWeatherApi.class, "getCityInfo", e);
        }
    }
}
