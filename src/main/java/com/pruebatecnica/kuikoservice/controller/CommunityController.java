package com.pruebatecnica.kuikoservice.controller;


import com.pruebatecnica.kuikoservice.dto.CommunityDto;
import com.pruebatecnica.kuikoservice.dto.CountProvincesDto;
import com.pruebatecnica.kuikoservice.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public ResponseEntity<List<CommunityDto>> getAllCommunities() {

        return ResponseEntity.ok(communityService.getAllCommunities());
    }

    @GetMapping("{id}")
    public ResponseEntity<CommunityDto> getCommunityById(@PathVariable Long id) {

        Optional<CommunityDto> community = Optional.ofNullable(communityService.getById(id));
        return ResponseEntity.ok(community.get());
    }

    @PostMapping
    public ResponseEntity<CommunityDto> createCommunity(@RequestBody CommunityDto communityDto) {
        CommunityDto newCommunity = communityService.createCommunity(communityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCommunity);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommunityDto> updateCommunity(@PathVariable Long id , @RequestBody CommunityDto communityDto) {

        CommunityDto result = communityService.updateCommunity(id, communityDto);

        return ResponseEntity.accepted().body(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {

        communityService.deleteCommunity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/countProvinces/{communityCode}")
    public ResponseEntity<CountProvincesDto> countProvinces(@PathVariable String communityCode) {

        CountProvincesDto countProvinces = communityService.countProvinces(communityCode);

        return ResponseEntity.ok(countProvinces);
    }
}
