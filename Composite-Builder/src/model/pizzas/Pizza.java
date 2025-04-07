package model.pizzas;

import model.base.ComidaCompuesta;
import model.base.PizzaClonable;

public abstract class Pizza extends ComidaCompuesta implements PizzaClonable {
    public Pizza() {
        super();
    }

    @Override
    public String getDescripcion() {
        return "Pizza con: " + super.getDescripcion();
    }

    @Override
    public abstract PizzaClonable Clonar();
}