package model.pizzas;

import model.base.ComidaCompuesta;
import model.base.PizzaClonable;
import model.ingredientes.Masa;
import model.ingredientes.Queso;
import model.ingredientes.SalsaTomate;
import model.ingredientes.Tomate;

public abstract class Pizza extends ComidaCompuesta implements PizzaClonable {
    public Tomate tomate;
    protected SalsaTomate salsaTomate;
    protected Queso queso;
    protected Masa masa;
    public Pizza() {
        super();
    }

    @Override
    public String getDescripcion() {
        return " con: " + super.getDescripcion();
    }

    @Override
    public abstract PizzaClonable clonar();
}