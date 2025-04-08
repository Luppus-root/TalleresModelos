package model.ingredientes;

import model.base.Comida;

public class Masa implements Comida {

    private String nombre;
    private double precioUnitario;

    public Masa(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Masa " + nombre + " ($" + precioUnitario + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}