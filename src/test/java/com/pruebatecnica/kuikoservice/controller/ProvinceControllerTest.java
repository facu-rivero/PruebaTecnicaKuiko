package com.pruebatecnica.kuikoservice.controller;

import com.pruebatecnica.kuikoservice.KuikoServiceApplicationTests;
import com.pruebatecnica.kuikoservice.dto.ProvinceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProvinceControllerTest extends KuikoServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testGetProvinceById() {

        String url ="/v1/api/province/1";

        ResponseEntity<ProvinceDto> response = restTemplate.getForEntity(url, ProvinceDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        ProvinceDto province = response.getBody();
        assertThat(province).isNotNull();
        assertThat(province.getProvinceCode()).isEqualTo("1");
        assertThat(province.getProvinceName()).isEqualTo("ARABA/ALAVA");
        assertThat(province.getCommunityCode()).isEqualTo("PV");

    }
}

