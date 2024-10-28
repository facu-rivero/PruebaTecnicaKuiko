package com.pruebatecnica.kuikoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDataDto {

    private String communityCode;
    private String communityName;
    private String provinceCode;
    private String provinceName;

}
