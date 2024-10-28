package com.pruebatecnica.kuikoservice.dto;

import com.pruebatecnica.kuikoservice.model.Province;

public class ProvinceDtoMapper {
    public static ProvinceDto toDto(Province province) {

        ProvinceDto provinceDto = new ProvinceDto();

            provinceDto.setId(province.getId());
            provinceDto.setProvinceCode(province.getProvinceCode());
            provinceDto.setProvinceName(province.getProvinceName());
            provinceDto.setCommunityCode(province.getCommunity().getCommunityCode());

        return provinceDto;
    }
}
