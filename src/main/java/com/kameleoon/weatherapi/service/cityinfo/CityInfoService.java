package com.kameleoon.weatherapi.service.cityinfo;

import com.kameleoon.weatherapi.entity.CityInfo;

import java.util.List;

public interface CityInfoService {

    CityInfo saveCityInfo(CityInfo cityInfo);

    boolean existByName(String cityName);

    String getCityName(String cityInfo);

    CityInfo getCityInfoByName(String cityName);

    List<CityInfo> getAllCityInfo();
}
