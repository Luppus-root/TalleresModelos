package com.beautyathome.backend.pattern.builder;

import com.beautyathome.backend.pattern.composite.ServicioSimple;
import java.util.ArrayList;
import java.util.List;

public class ManicureBuilder implements ServicioBuilder {
    private ServicioSimple servicio;
    // Atributos específicos de Manicure
    private String tipoUña;
    private List<String> diseñosPersonalizados = new ArrayList<>();

    public ManicureBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.servicio = new ServicioSimple();
        this.tipoUña = null;
        this.diseñosPersonalizados.clear();
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

    // Métodos y atributos propios de Manicure
    public void setTipoUña(String tipo) {
        this.tipoUña = tipo;
    }

    public void agregarDiseñoPersonalizado(String nombre) {
        this.diseñosPersonalizados.add(nombre);
    }

    @Override
    public ServicioSimple obtenerServicio() {
        String desc = servicio.getDescripcion() +
                " | Tipo de uña: " + (tipoUña != null ? tipoUña : "N/A") +
                " | Diseños personalizados: " + (diseñosPersonalizados.isEmpty() ? "Ninguno" : diseñosPersonalizados);
        servicio.setDescripcion(desc);
        return this.servicio;
    }
}

