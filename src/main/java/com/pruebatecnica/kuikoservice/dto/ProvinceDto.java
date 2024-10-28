package com.pruebatecnica.kuikoservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDto {

    private Long id;
    private String provinceCode;
    private String provinceName;
    private String communityCode;
}
