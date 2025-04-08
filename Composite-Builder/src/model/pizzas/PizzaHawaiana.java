package model.pizzas;

import model.base.PizzaClonable;
import model.ingredientes.*;

public class PizzaHawaiana extends Pizza {
    private Piña piña;

    public PizzaHawaiana() {
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

    public void setPiña(Piña piña) {
        this.piña = piña;
    }

    @Override
    public String getDescripcion() {
        return "Pizza Hawaiana con: " + super.getDescripcion();
    }

    @Override
    public PizzaClonable clonar() {
        PizzaHawaiana clone = new PizzaHawaiana();
        clone.setTomate(this.tomate);
        clone.setSalsaTomate(this.salsaTomate);
        clone.setQueso(this.queso);
        clone.setMasa(this.masa);
        clone.setPiña(this.piña);
        return clone;
    }
}