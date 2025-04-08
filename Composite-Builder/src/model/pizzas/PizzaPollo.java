package model.pizzas;

import model.base.PizzaClonable;
import model.ingredientes.*;

public class PizzaPollo extends Pizza {
    private Pollo pollo;

    public PizzaPollo() {
        super();
    }

    public void setTomate(Tomate tomate) {
        this.tomate = tomate;
    }

    public void setSalsaTomate(SalsaTomate salsaTomate) {
        this.salsaTomate = salsaTomate;
    }

    public void setQueso(Queso queso) {
        this.queso = queso;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public void setPollo(Pollo pollo) {
        this.pollo = pollo;
    }

    @Override
    public String getDescripcion() {
        return "Pizza de Pollo" + super.getDescripcion();
    }

    @Override
    public PizzaClonable clonar() {
        PizzaPollo clone = new PizzaPollo();
        clone.setTomate(this.tomate);
        clone.setSalsaTomate(this.salsaTomate);
        clone.setQueso(this.queso);
        clone.setMasa(this.masa);
        clone.setPollo(this.pollo);
        return clone;
    }
}