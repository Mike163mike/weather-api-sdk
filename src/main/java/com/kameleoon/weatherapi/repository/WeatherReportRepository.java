package com.kameleoon.weatherapi.repository;

import com.kameleoon.weatherapi.entity.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherReportRepository extends JpaRepository<WeatherReport, Integer> {
}
