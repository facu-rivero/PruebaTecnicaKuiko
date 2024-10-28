package com.pruebatecnica.kuikoservice.dto;

import com.pruebatecnica.kuikoservice.model.Community;

public class CountProvincesDtoMapper {
    public static CountProvincesDto toDto (Community community){

        CountProvincesDto countProvincesDto = new CountProvincesDto();

            countProvincesDto.setCommunityCode(community.getCommunityCode());
            countProvincesDto.setCommunityName(community.getCommunityName());
            countProvincesDto.setCountProvinces(community.getProvinces().size());

            return countProvincesDto;
    }
}
