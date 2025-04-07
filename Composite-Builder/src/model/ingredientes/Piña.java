package model.ingredientes;

import model.base.Comida;

public class Piña extends Comida {

    private String nombre;
    private double precioUnitario;

    public Piña(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Piña " + nombre + " ($" + precioUnitario + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}