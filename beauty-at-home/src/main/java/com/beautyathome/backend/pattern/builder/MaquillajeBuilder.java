package com.beautyathome.backend.pattern.builder;

import com.beautyathome.backend.pattern.composite.ServicioSimple;

public class MaquillajeBuilder implements ServicioBuilder {
    private ServicioSimple servicio;
    private String tipoMaquillaje;

    public MaquillajeBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.servicio = new ServicioSimple();
        this.tipoMaquillaje = null;
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

    public void setTipoMaquillaje(String tipo) {
        this.tipoMaquillaje = tipo;
    }

    @Override
    public ServicioSimple obtenerServicio() {
        String desc = servicio.getDescripcion() + " | Tipo de maquillaje: " + tipoMaquillaje;
        servicio.setDescripcion(desc);
        return this.servicio;
    }
}


