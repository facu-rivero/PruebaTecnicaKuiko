package com.pruebatecnica.kuikoservice.controller;

import com.pruebatecnica.kuikoservice.dto.ProvinceDto;
import com.pruebatecnica.kuikoservice.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/province")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping
    public ResponseEntity<List<ProvinceDto>> getAllProvinces() {

        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProvinceDto> getProvinceById(@PathVariable Long id) {

        Optional<ProvinceDto> province = Optional.ofNullable(provinceService.getById(id));
        return ResponseEntity.ok(province.get());
    }

    @PostMapping
    public ResponseEntity<ProvinceDto> createProvince(@RequestBody ProvinceDto provinceDto) {
        ProvinceDto newProvince = provinceService.createProvince(provinceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProvince);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProvinceDto> updateProvince(@PathVariable Long id , @RequestBody ProvinceDto provinceDto) {

        ProvinceDto result = provinceService.updateProvince(id, provinceDto);

        return ResponseEntity.accepted().body(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {

        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}
