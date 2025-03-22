package com.kameleoon.weatherapi.repository;

import com.kameleoon.weatherapi.entity.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherReportRepository extends JpaRepository<WeatherReport, Integer> {

    @Query("""
                SELECT wr FROM WeatherReport wr
                JOIN CityInfo ci ON ci.weatherReport = wr
                WHERE ci.name = :cityName
            """)
    WeatherReport findByCityName(@Param("cityName") String cityName);
}
