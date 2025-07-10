package com.beautyathome.backend.entity;

import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    private EstadoDisponibilidad estado;

    @ManyToOne
    private Profesional profesional;

    public void cambiarEstado(EstadoDisponibilidad nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public boolean estaDisponible() {
        return this.estado == EstadoDisponibilidad.DISPONIBLE;
    }
}

