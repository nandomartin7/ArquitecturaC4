package com.example.MicroServicioSRI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class SriService {
    private final RestTemplate restTemplate;

    public SriService(){
        this.restTemplate = new RestTemplate();
    }

    public boolean esContribuyente(String numeroRuc){
        String url = "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=" + numeroRuc;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        return response.getBody() != null && response.getBody();
    }
}
