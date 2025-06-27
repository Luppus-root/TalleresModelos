package com.beautyathome.beautyathome.agenda.state;

import com.beautyathome.beautyathome.agenda.Agenda;

// agenda/state/NoDisponible.java
public class NoDisponible implements DisponibilidadState {
    private final Agenda agenda;

    public NoDisponible(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public void reservar() {
        // no se puede reservar
    }

    @Override
    public void liberar() {
        // no se puede liberar desde no disponible
    }

    @Override
    public String obtenerEstado() {
        return "No disponible";
    }
}
