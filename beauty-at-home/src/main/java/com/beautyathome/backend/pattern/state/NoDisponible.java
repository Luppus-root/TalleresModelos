package com.beautyathome.backend.pattern.state;

public class NoDisponible implements EstadoDisponibilidad {

    @Override
    public String mostrarEstado() {
        return "No disponible";
    }

    @Override
    public void notificarDisponibilidad() {
        System.out.println("El profesional no está disponible en este momento.");
    }
}
