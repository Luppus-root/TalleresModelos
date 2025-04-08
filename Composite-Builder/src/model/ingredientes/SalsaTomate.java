package model.ingredientes;

import model.base.Comida;

public class SalsaTomate implements Comida {

    private Tomate tomate;
    private double cantidadTomate;

    public SalsaTomate(Tomate tomate, double cantidadTomate) {
        this.tomate = tomate;
        this.cantidadTomate = cantidadTomate;
    }

    @Override
    public String getDescripcion() {
        return "Salsa de tomate (con " + cantidadTomate + " de " + tomate.getNombre() + ")";
    }

    public Tomate getTomate() {
        return tomate;
    }

    public double getCantidadTomate() {
        return cantidadTomate;
    }
}