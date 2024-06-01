package com.example.MicroServicioSRI.controller;

import com.example.MicroServicioSRI.service.SriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sri")
public class SriController {
    @Autowired
    private SriService sriService;

    @GetMapping("/contribuyente/{numeroRuc}")
    public ResponseEntity<Boolean> verificarContribuyente(@PathVariable String numeroRuc){
        boolean esContribuyente = sriService.esContribuyente(numeroRuc);
        return ResponseEntity.ok(esContribuyente);
    }

}
