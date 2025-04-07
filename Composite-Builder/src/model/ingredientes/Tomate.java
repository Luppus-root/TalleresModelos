package model.ingredientes;

import model.base.Comida;

public class Tomate extends Comida {

    private String nombre;
    private double precioUnitario;

    public Tomate(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Tomate " + nombre + " ($" + precioUnitario + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}