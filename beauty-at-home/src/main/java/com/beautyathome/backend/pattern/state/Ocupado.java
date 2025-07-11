package com.beautyathome.backend.pattern.state;

public class Ocupado implements EstadoDisponibilidad {

    @Override
    public String mostrarEstado() {
        return "Ocupado";
    }

    @Override
    public void notificarDisponibilidad() {
        System.out.println("⏳ El profesional está actualmente ocupado.");
    }
}
