package com.kameleoon.weatherapi.service.cityinfo.impl;

import com.kameleoon.weatherapi.entity.CityInfo;
import com.kameleoon.weatherapi.repository.CityInfoRepository;
import com.kameleoon.weatherapi.service.cityinfo.CityInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityInfoServiceImpl implements CityInfoService {

    private final CityInfoRepository cityInfoRepository;

    @Override
    public void saveCityInfo(CityInfo cityInfo) {
        cityInfoRepository.save(cityInfo);
    }

    @Override
    public boolean existByName(String cityName) {
        return cityInfoRepository.existsCityInfoByName(cityName);
    }

    @Override
    public String getCityName(String cityInfo) {
        if (cityInfo.contains(",")) {
            return cityInfo.split(",")[0].trim();
        } else {
            return cityInfo.trim();
        }
    }

    @Override
    public CityInfo getCityInfoByName(String cityName) {
        return cityInfoRepository.getCityInfoByName(cityName);
    }

    @Override
    public List<CityInfo> getAllCityInfo() {
        return cityInfoRepository.findAll();
    }
}
