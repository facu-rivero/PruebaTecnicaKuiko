package com.pruebatecnica.kuikoservice.controller;

import com.pruebatecnica.kuikoservice.dto.WeatherDto;
import com.pruebatecnica.kuikoservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("{provinceName}")
    public ResponseEntity<WeatherDto> getWeatherByProvinceName(@PathVariable String provinceName) {

        WeatherDto weatherResponse = weatherService.getWeatherByProvinceName(provinceName);
        return ResponseEntity.ok(weatherResponse);
    }
}
