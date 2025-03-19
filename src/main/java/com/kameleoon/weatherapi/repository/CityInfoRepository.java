package com.kameleoon.weatherapi.repository;

import com.kameleoon.weatherapi.entity.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {
}
