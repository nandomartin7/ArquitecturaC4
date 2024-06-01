package com.example.MicroServicioANT.controller;

import com.example.MicroServicioANT.service.AntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ant")
public class AntController {

    @Autowired
    private AntService antService;

    @GetMapping("/puntos/{cedula}")
    public ResponseEntity<Integer> verificarPuntos(@PathVariable String cedula) {
        int puntos = antService.obtenerPuntos(cedula);
        return ResponseEntity.ok(puntos);
    }
}