package com.beautyathome.beautyathome.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Profesional {
    protected String nombre;
    protected String experiencia;
    protected List<Servicio> servicios = new ArrayList<>();
    protected List<String> zonasCobertura = new ArrayList<>();

    public Profesional(String nombre, String experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public List<String> getZonasCobertura() {
        return zonasCobertura;
    }

    public abstract boolean usaProductosExclusivos();
    public abstract String tipo();
}

