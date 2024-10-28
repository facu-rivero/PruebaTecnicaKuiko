package com.pruebatecnica.kuikoservice.service.implement;

import com.pruebatecnica.kuikoservice.dto.*;
import com.pruebatecnica.kuikoservice.model.Community;
import com.pruebatecnica.kuikoservice.repository.CommunityRepository;
import com.pruebatecnica.kuikoservice.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;


    @Override
    public List<CommunityDto> getAllCommunities() {

        List<Community> communities = communityRepository.findAll();
        return communities.stream()
                .map(community -> new CommunityDto(community.getId(),community.getCommunityCode(), community.getCommunityName()))
                .collect(Collectors.toList());
    }


    @Override
    public CommunityDto getById(Long id) {
        Optional<Community> communityOptional = communityRepository.findById(id);
            if (!communityOptional.isPresent()) {
                throw new NoSuchElementException("La comunidad no existe");
            }

        Community community = communityOptional.get();
        return CommunityDtoMapper.toDto(community);

    }

    @Override
    public CommunityDto createCommunity(CommunityDto communityDto) {

        Community newCommunity = new Community();
        newCommunity.setCommunityCode(communityDto.getCommunityCode());
        newCommunity.setCommunityName(communityDto.getCommunityName());

        Community result = communityRepository.save(newCommunity);

        return CommunityDtoMapper.toDto(result);
    }

    @Override
    public CommunityDto updateCommunity(Long id, CommunityDto communityDto) {

        Optional<Community> communityOptional = communityRepository.findById(id);
        if (!communityOptional.isPresent()) {
            throw new NoSuchElementException("La comunidad que desea actualizar no existe");
        }
        Community community =  communityRepository.findById(id).get();
        community.setCommunityCode(communityDto.getCommunityCode());
        community.setCommunityName(communityDto.getCommunityName());

        Community result = communityRepository.save(community);

        return CommunityDtoMapper.toDto(result);
    }

    @Override
    public void deleteCommunity(Long id) {

        Optional<Community> communityOptional = communityRepository.findById(id);
        if (!communityOptional.isPresent()) {
            throw new NoSuchElementException("La comunidad que desea eliminar no existe");
        }
        communityRepository.deleteById(id);
    }

    @Override
    public CountProvincesDto countProvinces(String communityCode) {

        Community community = communityRepository.findByCommunityCode(communityCode)
                .orElseThrow(() -> new NoSuchElementException("La Comunidad Autonoma solicitada no fue encontrada"));

        CountProvincesDto countProvinces = CountProvincesDtoMapper.toDto(community);

        return countProvinces;
    }
}
