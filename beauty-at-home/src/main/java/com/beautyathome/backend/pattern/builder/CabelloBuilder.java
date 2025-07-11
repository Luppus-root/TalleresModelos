package com.beautyathome.backend.pattern.builder;

import com.beautyathome.backend.pattern.composite.ServicioSimple;
import java.util.ArrayList;
import java.util.List;

public class CabelloBuilder implements ServicioBuilder {
    private ServicioSimple servicio;

    private String tipoCabello;
    private List<String> tratamientos = new ArrayList<>();

    public CabelloBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.servicio = new ServicioSimple();
        this.tipoCabello = null;
        this.tratamientos.clear();
    }

    @Override
    public void setNombre(String nombre) {
        servicio.setNombre(nombre);
    }

    @Override
    public void setDescripcion(String descripcion) {
        servicio.setDescripcion(descripcion);
    }

    @Override
    public void setPrecio(double precio) {
        servicio.setPrecio(precio);
    }

    public void setTipoCabello(String tipo) {
        this.tipoCabello = tipo;
    }

    public void agregarTratamiento(String tratamiento) {
        this.tratamientos.add(tratamiento);
    }

    @Override
    public ServicioSimple obtenerServicio() {

        String desc = servicio.getDescripcion() + " | Tipo de cabello: " + tipoCabello + " | Tratamientos: " + tratamientos;
        servicio.setDescripcion(desc);
        return this.servicio;
    }
}

