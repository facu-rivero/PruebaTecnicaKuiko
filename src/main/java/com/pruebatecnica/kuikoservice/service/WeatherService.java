package com.pruebatecnica.kuikoservice.service;

import com.pruebatecnica.kuikoservice.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getWeatherByProvinceName(String provinceName);
}
