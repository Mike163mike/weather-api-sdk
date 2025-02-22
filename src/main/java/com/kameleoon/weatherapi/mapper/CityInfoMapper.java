package com.kameleoon.weatherapi.mapper;

import com.kameleoon.weatherapi.dto.CityInfoDto;
import com.kameleoon.weatherapi.entity.CityInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityInfoMapper {

    CityInfoDto toDto(CityInfo cItyInfo);

    @Mapping(target = "weatherReports", ignore = true)
    CityInfo toEntity(CityInfoDto cityInfoDto);
}
