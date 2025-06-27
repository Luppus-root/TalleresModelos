package com.beautyathome.beautyathome.agenda.state;

public interface DisponibilidadState {
    void reservar();
    void liberar();
    String obtenerEstado();
}
