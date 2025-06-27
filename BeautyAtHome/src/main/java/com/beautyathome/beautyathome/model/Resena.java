package com.beautyathome.beautyathome.model;

import com.beautyathome.beautyathome.visitor.ResenaVisitor;

import java.time.LocalDate;
import java.util.List;

// model/Resena.java
public class Resena {
    private final String idClienteAnonimo;
    private final String texto;
    private final int estrellas;
    private final LocalDate fecha;
    private final List<String> imagenes;

    public Resena(String idClienteAnonimo, String texto, int estrellas, LocalDate fecha, List<String> imagenes) {
        this.idClienteAnonimo = idClienteAnonimo;
        this.texto = texto;
        this.estrellas = estrellas;
        this.fecha = fecha;
        this.imagenes = imagenes;
    }

    public int getEstrellas() { return estrellas; }
    public String getTexto() { return texto; }
    public List<String> getImagenes() { return imagenes; }
    public LocalDate getFecha() { return fecha; }

    public void aceptar(ResenaVisitor visitor) {
        visitor.visitar(this);
    }
}
