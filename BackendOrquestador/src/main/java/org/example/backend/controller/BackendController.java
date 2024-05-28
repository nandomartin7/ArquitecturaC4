package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {

    @GetMapping("/api/saludo/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "¡Hola, " + nombre + "!";
    }
}
