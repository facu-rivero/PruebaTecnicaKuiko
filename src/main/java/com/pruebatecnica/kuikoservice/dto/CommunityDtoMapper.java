package com.pruebatecnica.kuikoservice.dto;

import com.pruebatecnica.kuikoservice.model.Community;

public class CommunityDtoMapper {
    public static CommunityDto toDto(Community community) {

        CommunityDto communityDto = new CommunityDto();

            communityDto.setId(community.getId());
            communityDto.setCommunityCode(community.getCommunityCode());
            communityDto.setCommunityName(community.getCommunityName());

        return communityDto;
    }
}
