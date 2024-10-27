package com.pruebatecnica.kuikoservice.service;

import com.pruebatecnica.kuikoservice.dto.CommunityDto;
import com.pruebatecnica.kuikoservice.model.Community;

import java.util.List;

public interface CommunityService {

    List<CommunityDto> getAllCommunities();

    CommunityDto getById(Long id);

    CommunityDto createCommunity(CommunityDto communityDto);

    CommunityDto updateCommunity(Long id, CommunityDto communityDto);

    void deleteCommunity(Long id);
}
