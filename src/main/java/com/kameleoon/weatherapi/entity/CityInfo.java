package com.kameleoon.weatherapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "city_info")
public class CityInfo {

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "latitude")
    private double longitude;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "cityInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherReport> weatherReports = new ArrayList<>();
}
