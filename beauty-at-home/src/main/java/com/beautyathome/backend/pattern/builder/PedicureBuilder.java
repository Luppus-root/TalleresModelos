package com.beautyathome.backend.pattern.builder;

import com.beautyathome.backend.pattern.composite.ServicioSimple;
import java.util.ArrayList;
import java.util.List;

public class PedicureBuilder implements ServicioBuilder {
    private ServicioSimple servicio;
    // Atributos específicos de Pedicure
    private List<String> tratamientosEspeciales = new ArrayList<>();

    public PedicureBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.servicio = new ServicioSimple();
        this.tratamientosEspeciales.clear();
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

    // Método propio de Pedicure
    public void agregarTratamientoEspecial(String tratamiento) {
        this.tratamientosEspeciales.add(tratamiento);
    }

    @Override
    public ServicioSimple obtenerServicio() {
        String desc = servicio.getDescripcion() +
                " | Tratamientos especiales: " + (tratamientosEspeciales.isEmpty() ? "Ninguno" : tratamientosEspeciales);
        servicio.setDescripcion(desc);
        return this.servicio;
    }
}
