package model.ingredientes;

import model.base.Comida;

public class Queso extends Comida {

    private String nombre;
    private double precioUnitario;

    public Queso(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Queso " + nombre + " ($" + precioUnitario + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}