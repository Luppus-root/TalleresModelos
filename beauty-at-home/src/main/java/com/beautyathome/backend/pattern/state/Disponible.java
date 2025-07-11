package com.beautyathome.backend.pattern.state;

public class Disponible implements EstadoDisponibilidad {

    @Override
    public String mostrarEstado() {
        return "Disponible";
    }

    @Override
    public void notificarDisponibilidad() {
        System.out.println("El profesional está disponible para nuevos servicios.");
    }
}
