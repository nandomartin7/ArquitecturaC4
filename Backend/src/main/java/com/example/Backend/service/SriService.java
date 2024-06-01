package com.example.Backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SriService {

    private final RestTemplate restTemplate;
    private final String sriUrl;

    public SriService(RestTemplate restTemplate, @Value("${microservicio.sri.url}") String sriUrl) {
        this.restTemplate = restTemplate;
        this.sriUrl = sriUrl;
    }

    public boolean esContribuyente(String numeroRuc) {
        String url = sriUrl + numeroRuc;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        return response.getBody() != null && response.getBody();
    }
}