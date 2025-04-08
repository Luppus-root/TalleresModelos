package model.pizzas;

import model.base.Comida;
import model.base.ComidaCompuesta;
import model.base.PizzaClonable;
import model.ingredientes.*;

public abstract class Pizza extends ComidaCompuesta implements PizzaClonable {
    public Tomate tomate;
    protected SalsaTomate salsaTomate;
    protected Queso queso;
    protected Masa masa;

    public Pizza() {
        super();
    }

    public void agregar(Comida ingrediente) {
        agregarComponente(ingrediente);
    }

    public String getDescripcion() {
        return "\nIngredientes:\n" + super.getDescripcion();
    }
}
