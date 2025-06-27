package com.beautyathome.beautyathome.agenda.state;

import com.beautyathome.beautyathome.agenda.Agenda;

public class NoDisponible implements DisponibilidadState {
    private final Agenda agenda;

    public NoDisponible(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public void reservar() {

    }

    @Override
    public void liberar() {

    }

    @Override
    public String obtenerEstado() {
        return "No disponible";
    }
}
