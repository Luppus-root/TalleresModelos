package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.builder.ServicioBuilder;
import com.beautyathome.backend.pattern.composite.ServicioSimple;
import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;
import com.beautyathome.backend.pattern.observer.ObservadorDisponibilidad;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Profesional {
    protected ServicioBuilder servicioBuilder;
    protected EstadoDisponibilidad estado;
    protected String nombre;
    protected BufferedImage fotografia;
    protected int añosExperiencia;
    protected String perfil;
    protected ServicioSimple servicioSI;
    protected List<ObservadorDisponibilidad> observadores = new ArrayList<>();
    protected String disponibilidad;
    protected int id;

    public Profesional() {}

    public Profesional(ServicioBuilder servicioBuilder) {
        this.servicioBuilder = servicioBuilder;
    }

    public abstract Profesional crearProfesional();

    public void cambiarBuilder(ServicioBuilder nuevoBuilder) {
        this.servicioBuilder = nuevoBuilder;
    }

    public void construir() {
        // Lógica para construir el profesional con el builder
    }

    public void notificarDisponibilidad() {
        for (ObservadorDisponibilidad obs : observadores) {
            obs.actualizar(disponibilidad);
        }
    }

    public void setEstado(EstadoDisponibilidad nuevoEstado) {
        this.estado = nuevoEstado;
        this.disponibilidad = nuevoEstado.mostrarEstado();
        notificarDisponibilidad();
    }

    public EstadoDisponibilidad getEstado() {
        return estado;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void agregarObservador(ObservadorDisponibilidad obs) {
        observadores.add(obs);
    }

    public void eliminarObservador(ObservadorDisponibilidad obs) {
        observadores.remove(obs);
    }

    // Getters y setters estándar
    public ServicioBuilder getServicioBuilder() { return servicioBuilder; }
    public void setServicioBuilder(ServicioBuilder servicioBuilder) { this.servicioBuilder = servicioBuilder; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public void setFotografia(BufferedImage fotografia) { this.fotografia = fotografia; }
    public BufferedImage getFotografia() { return fotografia; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }
    public int getAñosExperiencia() { return añosExperiencia; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
    public String getPerfil() { return perfil; }
    public void setServicioSI(ServicioSimple servicioSI) { this.servicioSI = servicioSI; }
    public ServicioSimple getServicioSI() { return servicioSI; }
    public List<ObservadorDisponibilidad> getObservadores() { return observadores; }
    public void setObservadores(List<ObservadorDisponibilidad> observadores) { this.observadores = observadores; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
