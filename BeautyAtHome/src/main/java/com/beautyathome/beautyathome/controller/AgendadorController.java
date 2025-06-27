package com.beautyathome.beautyathome.controller;

import com.beautyathome.beautyathome.service.core.AgendadorChainService;
import com.beautyathome.beautyathome.service.dto.AgendamientoSolicitud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendar")
@RequiredArgsConstructor
public class AgendadorController {

    private final AgendadorChainService chainService;

    @PostMapping
    public ResponseEntity<String> agendar(@RequestBody AgendamientoSolicitud solicitud) {
        boolean exito = chainService.procesarSolicitud(solicitud);
        return exito
                ? ResponseEntity.ok("Servicio agendado correctamente.")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("No se encontró profesional disponible.");
    }
}
