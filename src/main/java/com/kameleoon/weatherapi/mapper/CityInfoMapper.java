package com.kameleoon.weatherapi.mapper;

import com.kameleoon.weatherapi.dto.cityinfo.CityInfoDto;
import com.kameleoon.weatherapi.entity.CityInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityInfoMapper {

    CityInfoDto toDto(CityInfo cItyInfo);

    @Mapping(target = "weatherReport", ignore = true)
    CityInfo toEntity(CityInfoDto cityInfoDto);
}
