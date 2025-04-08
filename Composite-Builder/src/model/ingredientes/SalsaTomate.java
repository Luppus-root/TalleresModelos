package model.ingredientes;

import model.base.Comida;

public class SalsaTomate implements Comida {

    private Tomate tipo;
    private double precioUnitario;

    public SalsaTomate(Tomate tipo, double precioUnitario) {
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String getDescripcion() {
        return "Salsa de " + tipo.getNombre() + " ($" + precioUnitario + ")";
    }

    @Override
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
