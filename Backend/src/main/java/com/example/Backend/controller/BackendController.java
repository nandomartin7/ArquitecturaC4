package com.example.Backend.controller;

import com.example.Backend.service.AntService;
import com.example.Backend.service.SriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class BackendController {

    private final SriService sriService;
    private final AntService antService;

    @Autowired
    public BackendController(SriService sriService, AntService antService) {
        this.sriService = sriService;
        this.antService = antService;
    }

    @GetMapping("/sri/contribuyente/{numeroRuc}")
    public ResponseEntity<Boolean> verificarContribuyente(@PathVariable String numeroRuc){
        boolean esContribuyente = sriService.esContribuyente(numeroRuc);
        return ResponseEntity.ok(esContribuyente);
    }

    @GetMapping("/ant/puntos/{cedula}")
    public ResponseEntity<Integer> verificarPuntos(@PathVariable String cedula) {
        int puntos = antService.obtenerPuntos(cedula);
        return ResponseEntity.ok(puntos);
    }
}
