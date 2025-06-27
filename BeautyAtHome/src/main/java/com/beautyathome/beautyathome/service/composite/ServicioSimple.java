package com.beautyathome.beautyathome.service.composite;

import java.util.List;

// service/composite/ServicioSimple.java
public class ServicioSimple implements ServicioComponent {

    private final String nombre;
    private final String descripcion;
    private final double precio;
    private final List<String> imagenes;

    public ServicioSimple(String nombre, String descripcion, double precio, List<String> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenes = imagenes;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public String getDescripcion() { return descripcion; }

    @Override
    public double getPrecio() { return precio; }

    @Override
    public List<String> getImagenes() { return imagenes; }
}
