package com.beautyathome.beautyathome.agenda.state;

import com.beautyathome.beautyathome.agenda.Agenda;

public class Disponible implements DisponibilidadState {
    private final Agenda agenda;
    private final String profesionalId;

    public Disponible(Agenda agenda, String profesionalId) {
        this.agenda = agenda;
        this.profesionalId = profesionalId;
    }

    @Override
    public void reservar() {
        agenda.cambiarEstado(profesionalId, new Ocupado(agenda, profesionalId));
    }

    @Override
    public void liberar() {
    }

    @Override
    public String obtenerEstado() {
        return "Disponible";
    }
}
