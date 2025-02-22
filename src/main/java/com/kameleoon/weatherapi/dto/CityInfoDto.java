package com.kameleoon.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityInfoDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("country")
    private String country;

    @JsonProperty("state")
    private String state;
}
