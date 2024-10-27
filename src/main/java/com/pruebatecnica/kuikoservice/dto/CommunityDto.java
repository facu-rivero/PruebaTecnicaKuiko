package com.pruebatecnica.kuikoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {

    private Long id;
    private String communityCode;
    private String communityName;
}
