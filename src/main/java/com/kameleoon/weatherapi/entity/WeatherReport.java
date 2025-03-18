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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    @EqualsAndHashCode.Include
    private OffsetDateTime changeDate;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @EqualsAndHashCode.Include
    private CityInfo cityInfo;

    @Embedded
    @Column(name = "weather")
    private Weather weather;

    @Embedded
    @Column(name = "temperature")
    private Temperature temperature;

    @Column(name = "visibility")
    private Integer visibility;

    @Embedded
    @Column(name = "wind")
    private Wind wind;

    @Column(name = "date_time")
    private Long dateTime;

    @Embedded
    @Column(name = "sys")
    private Sys sys;

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
}
