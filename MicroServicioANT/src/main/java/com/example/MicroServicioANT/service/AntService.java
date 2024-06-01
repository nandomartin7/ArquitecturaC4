package com.example.MicroServicioANT.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Service
public class AntService {

    private final RestTemplate restTemplate;

    public AntService() {
        this.restTemplate = new RestTemplate();
    }

    public int obtenerPuntos(String cedula) {
        String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion=" + cedula;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Obtén el HTML como un String
        String html = response.getBody();

        // Encuentra la posición de la cadena de caracteres "Información adicional de Puntos"
        int pos = html.indexOf("Información adicional de Puntos");

        // Extrae la parte del HTML que contiene los puntos
        String puntosHtml = html.substring(pos, pos + 60); // Ajusta el '50' según sea necesario

        //Encuentra la posicion en donde se encuentran los puntos
        int startPos = puntosHtml.indexOf(">")+1;
        int endPos = puntosHtml.indexOf("<");

        //Extrae la parte de los puntos
        String puntosLicencia = puntosHtml.substring(startPos,endPos);

        // Convierte el string de puntos a un entero
        int puntos = Integer.parseInt(puntosLicencia);

        return puntos;
    }
}