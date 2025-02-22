package com.kameleoon.weatherapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "weather_report")
public class WeatherReport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @UpdateTimestamp
    @Column(name = "change_date")
    private OffsetDateTime changeDate;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private CityInfo cityInfo;

    @Column(name = "weather")
    @Embedded
    private Weather weather;

    @Column(name = "temperature")
    @Embedded
    private Temperature temperature;

    @Column(name = "wind")
    @Embedded
    private Wind wind;

    @Column(name = "sys")
    @Embedded
    private Sys sys;

    @Column(name = "visibility")
    private Integer visibility;

    @Column(name = "date_time")
    private Long dateTime;

    @Column(name = "time_zone")
    private Integer timeZone;

    @Column(name = "name")
    private String name;

    @Embeddable
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Weather {

        private String main;

        private String description;
    }

    @Embeddable
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Temperature {

        private double temp;

        private double feelsLike;
    }

    @Embeddable
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Wind {

        private double speed;
    }

    @Embeddable
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Sys {

        private Long sunrise;

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


}
