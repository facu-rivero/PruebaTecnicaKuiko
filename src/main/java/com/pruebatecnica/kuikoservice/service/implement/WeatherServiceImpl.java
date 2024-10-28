package com.pruebatecnica.kuikoservice.service.implement;

import com.pruebatecnica.kuikoservice.dto.WeatherDto;
import com.pruebatecnica.kuikoservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherDto getWeatherByProvinceName(String provinceName) {

        // La Apikey de prueba ya se encuentra vencida debido a que era una gratiuta con poca duracion

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                // se Harcodearon las coordenadas de Madrid para la prueba de la Api Externa
                .queryParam("lat", 40.30)
                .queryParam("lon", 3.4)
                .queryParam("exclude", "minutely,hourly,alerts")
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build().toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> mainData = (Map<String, Object>) response.get("main");

        WeatherDto weatherResponse = new WeatherDto();
        weatherResponse.setCurrentDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        weatherResponse.setCurrentTemp((double) mainData.get("temp"));
        weatherResponse.setMaxTemperature((double) mainData.get("temp_max"));
        weatherResponse.setMinTemperature((double) mainData.get("temp_min"));

        return weatherResponse;
    }
}
