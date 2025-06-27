package com.beautyathome.beautyathome.controller;

import com.beautyathome.beautyathome.agenda.Agenda;
import com.beautyathome.beautyathome.agenda.state.NoDisponible;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final Agenda agenda;

    @GetMapping("/estado/{profesionalId}")
    public ResponseEntity<String> obtenerEstado(@PathVariable String profesionalId) {
        return ResponseEntity.ok(agenda.obtenerEstado(profesionalId));
    }

    @PostMapping("/reservar/{profesionalId}")
    public ResponseEntity<String> reservar(@PathVariable String profesionalId) {
        agenda.reservar(profesionalId);
        return ResponseEntity.ok("Estado cambiado a OCUPADO para " + profesionalId);
    }

    @PostMapping("/liberar/{profesionalId}")
    public ResponseEntity<String> liberar(@PathVariable String profesionalId) {
        agenda.liberar(profesionalId);
        return ResponseEntity.ok("Estado cambiado a DISPONIBLE para " + profesionalId);
    }

    @PostMapping("/marcarNoDisponible/{profesionalId}")
    public ResponseEntity<String> marcarNoDisponible(@PathVariable String profesionalId) {
        agenda.cambiarEstado(profesionalId, new NoDisponible(agenda, profesionalId));
        return ResponseEntity.ok("Estado cambiado a NO DISPONIBLE para " + profesionalId);
    }
}
