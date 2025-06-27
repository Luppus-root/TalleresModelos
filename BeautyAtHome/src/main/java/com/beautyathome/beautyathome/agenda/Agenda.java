package com.beautyathome.beautyathome.agenda;

import com.beautyathome.beautyathome.agenda.observer.ObservadorDisponibilidad;
import com.beautyathome.beautyathome.agenda.state.DisponibilidadState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {

    private static Agenda instancia;

    private final Map<String, DisponibilidadState> estadosProfesionales = new HashMap<>();
    private final List<ObservadorDisponibilidad> observadores = new ArrayList<>();

    private Agenda() {}

    public static Agenda obtenerInstancia() {
        if (instancia == null) {
            synchronized (Agenda.class) {
                if (instancia == null) instancia = new Agenda();
            }
        }
        return instancia;
    }

    public void cambiarEstado(String profesionalId, DisponibilidadState nuevoEstado) {
        estadosProfesionales.put(profesionalId, nuevoEstado);
        notificar(profesionalId);
    }

    public void setEstadoActualPara(String profesionalId, DisponibilidadState estado) {
        estadosProfesionales.put(profesionalId, estado);
    }

    public String obtenerEstado(String profesionalId) {
        DisponibilidadState estado = estadosProfesionales.get(profesionalId);
        return (estado != null) ? estado.obtenerEstado() : "Desconocido";
    }

    public void agregarObservador(ObservadorDisponibilidad obs) {
        observadores.add(obs);
    }

    private void notificar(String profesionalId) {
        String estado = obtenerEstado(profesionalId);
        observadores.forEach(o -> o.notificarCambioEstado(profesionalId, estado));
    }

    public DisponibilidadState getEstadoActualPara(String profesionalId) {
        return estadosProfesionales.get(profesionalId);
    }
    public void reservar(String profesionalId) {
        DisponibilidadState estado = estadosProfesionales.get(profesionalId);
        if (estado != null) {
            estado.reservar();
            notificar(profesionalId);
        }
    }
    public void liberar(String profesionalId) {
        DisponibilidadState estado = estadosProfesionales.get(profesionalId);
        if (estado != null) {
            estado.liberar();
            notificar(profesionalId);
        }
    }




}
