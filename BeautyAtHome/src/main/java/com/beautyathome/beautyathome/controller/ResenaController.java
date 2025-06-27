package com.beautyathome.beautyathome.controller;

import com.beautyathome.beautyathome.repository.dto.ResenaDTO;
import com.beautyathome.beautyathome.repository.dto.ResenaPrivadaDTO;
import com.beautyathome.beautyathome.service.core.ResenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller/ResenaController.java
@RestController
@RequestMapping("/resenas")
@RequiredArgsConstructor
public class ResenaController {

    private final ResenaService service;

    @PostMapping("/{profesionalId}")
    public ResponseEntity<String> publicar(
            @PathVariable String profesionalId,
            @RequestBody ResenaDTO dto
    ) {
        service.publicar(profesionalId, dto);
        return ResponseEntity.ok("Reseña publicada");
    }

    @GetMapping("/{profesionalId}")
    public ResponseEntity<List<ResenaPrivadaDTO>> ver(
            @PathVariable String profesionalId,
            @RequestParam(defaultValue = "false") boolean verTodo
    ) {
        boolean tienePermiso = verTodo; // lógica futura con roles
        return ResponseEntity.ok(service.obtenerConPrivacidad(profesionalId, tienePermiso));
    }

    @GetMapping("/{profesionalId}/promedio")
    public ResponseEntity<Double> promedio(@PathVariable String profesionalId) {
        return ResponseEntity.ok(service.promedioEstrellas(profesionalId));
    }
}

