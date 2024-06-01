package com.example.Backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AntService {

    private final RestTemplate restTemplate;
    private final String antUrl;

    public AntService(RestTemplate restTemplate, @Value("${microservicio.ant.url}") String antUrl) {
        this.restTemplate = restTemplate;
        this.antUrl = antUrl;
    }

    public int obtenerPuntos(String cedula) {
        String url = antUrl + cedula;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();
        return Integer.parseInt(body.trim());
    }
}