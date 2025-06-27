package com.beautyathome.beautyathome.model;

import java.util.List;
import java.util.ArrayList;

public class Servicio {
    private String nombre;
    private String descripcion;
    private Double precio;
    private List<String> imagenes;

    private Servicio(Builder builder) {
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.precio = builder.precio;
        this.imagenes = builder.imagenes;
    }

    public static class Builder {
        private String nombre;
        private String descripcion;
        private Double precio;
        private List<String> imagenes = new ArrayList<>();

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder precio(Double precio) {
            this.precio = precio;
            return this;
        }

        public Builder imagen(String imagen) {
            this.imagenes.add(imagen);
            return this;
        }

        public Builder imagenes(List<String> imagenes) {
            this.imagenes = imagenes;
            return this;
        }

        public Servicio build() {
            return new Servicio(this);
        }
    }
}
