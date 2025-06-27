package com.beautyathome.beautyathome.service.composite;

public class ServicioConTratamientoVIP extends ServicioDecorator {

    public ServicioConTratamientoVIP(ServicioComponent base) {
        super(base);
    }

    @Override
    public String getDescripcion() {
        return servicioBase.getDescripcion() + " (Incluye atención personalizada VIP)";
    }

    @Override
    public double getPrecio() {
        return servicioBase.getPrecio() + 15000; // adicional por el tratamiento
    }
}
