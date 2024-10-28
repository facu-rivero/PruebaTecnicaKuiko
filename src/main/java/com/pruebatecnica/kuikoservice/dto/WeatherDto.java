package com.pruebatecnica.kuikoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

    private String currentDate;
    private double currentTemp;
    private double maxTemperature;
    private double minTemperature;
}
