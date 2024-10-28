package com.pruebatecnica.kuikoservice.dto;

import com.pruebatecnica.kuikoservice.model.Province;

public class ProvinceDataDtoMapper {
    public static ProvinceDataDto toDto(Province province) {

        ProvinceDataDto provinceDataDto = new ProvinceDataDto();

            provinceDataDto.setCommunityCode(province.getCommunity().getCommunityCode());
            provinceDataDto.setCommunityName(province.getCommunity().getCommunityName());
            provinceDataDto.setProvinceCode(province.getProvinceCode());
            provinceDataDto.setProvinceName(province.getProvinceName());

            return provinceDataDto;
    }
}
