package com.beautyathome.beautyathome.service.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaqueteServicio implements ServicioComponent {

    private final String nombre;
    private final List<ServicioComponent> componentes = new ArrayList<>();

    public PaqueteServicio(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ServicioComponent servicio) {
        componentes.add(servicio);
    }

    public void eliminar(ServicioComponent servicio) {
        componentes.remove(servicio);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return componentes.stream()
                .map(ServicioComponent::getDescripcion)
                .collect(Collectors.joining(" + "));
    }

    @Override
    public double getPrecio() {
        return componentes.stream().mapToDouble(ServicioComponent::getPrecio).sum();
    }

    @Override
    public List<String> getImagenes() {
        return componentes.stream()
                .flatMap(c -> c.getImagenes().stream())
                .collect(Collectors.toList());
    }
}
