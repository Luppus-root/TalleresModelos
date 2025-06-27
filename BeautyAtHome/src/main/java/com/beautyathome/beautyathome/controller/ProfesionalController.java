package com.beautyathome.beautyathome.controller;

import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.repository.dto.ProfesionalDTO;
import com.beautyathome.beautyathome.service.core.ProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
@RequiredArgsConstructor
public class ProfesionalController {

    private final ProfesionalService servicio;

    @PostMapping
    public ResponseEntity<Profesional> crear(@RequestBody ProfesionalDTO dto) {
        return ResponseEntity.ok(servicio.crearProfesional(dto));
    }

    @GetMapping
    public ResponseEntity<List<Profesional>> listar() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Profesional> obtener(@PathVariable String nombre) {
        return ResponseEntity.ok(servicio.obtenerPorNombre(nombre));
    }
}
