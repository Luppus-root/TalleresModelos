package model.ingredientes;

import model.base.Comida;

public class Pollo implements Comida {

    private String nombre;
    private double precioUnitario;

    public Pollo(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Pollo " + nombre + " ($" + precioUnitario + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}