package com.beautyathome.beautyathome.service.composite;

import java.util.List;

// service/composite/ServicioDecorator.java
public abstract class ServicioDecorator implements ServicioComponent {
    protected ServicioComponent servicioBase;

    public ServicioDecorator(ServicioComponent servicioBase) {
        this.servicioBase = servicioBase;
    }

    @Override
    public String getNombre() {
        return servicioBase.getNombre();
    }

    @Override
    public String getDescripcion() {
        return servicioBase.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return servicioBase.getPrecio();
    }

    @Override
    public List<String> getImagenes() {
        return servicioBase.getImagenes();
    }
}

