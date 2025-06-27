package com.beautyathome.beautyathome.agenda.observer;

public interface ObservadorDisponibilidad {
    void notificarCambioEstado(String profesionalId, String nuevoEstado);
}
