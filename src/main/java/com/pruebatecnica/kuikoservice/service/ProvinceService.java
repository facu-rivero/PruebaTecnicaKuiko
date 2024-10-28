package com.pruebatecnica.kuikoservice.service;

import com.pruebatecnica.kuikoservice.dto.ProvinceDataDto;
import com.pruebatecnica.kuikoservice.dto.ProvinceDto;

import java.util.List;

public interface ProvinceService {
    List<ProvinceDto> getAllProvinces();

    ProvinceDto getById(Long id);

    ProvinceDto createProvince(ProvinceDto provinceDto);

    ProvinceDto updateProvince(Long id, ProvinceDto provinceDto);

    void deleteProvince(Long id);

    ProvinceDataDto getProvinceData(String provinceCode);
}
