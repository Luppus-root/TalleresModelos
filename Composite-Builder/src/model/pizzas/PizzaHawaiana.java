package model.pizzas;

import model.base.PizzaClonable;
import model.ingredientes.Masa;
import model.ingredientes.Piña;
import model.ingredientes.Pollo;
import model.ingredientes.Queso;
import model.ingredientes.SalsaTomate;
import model.ingredientes.Tomate;

public class PizzaHawaiana extends Pizza {

    private Tomate tomate;
    private SalsaTomate salsaTomate;
    private Queso queso;
    private Masa masa;
    private Pollo pollo;
    private Piña piña;

    public PizzaHawaiana(Tomate tomate, SalsaTomate salsaTomate, Queso queso, Masa masa, Pollo pollo, Piña piña) {
        super();
        this.tomate = tomate;
        this.salsaTomate = salsaTomate;
        this.queso = queso;
        this.masa = masa;
        this.pollo = pollo;
        this.piña = piña;

        this.agregar(tomate);
        this.agregar(salsaTomate);
        this.agregar(queso);
        this.agregar(masa);
        this.agregar(pollo);
        this.agregar(piña);
    }

    @Override
    public String getDescripcion() {
        return "Pizza Hawaiana con: " + super.getDescripcion();
    }

    @Override
    public PizzaClonable Clonar() {
        return new PizzaHawaiana(tomate, salsaTomate, queso, masa, pollo, piña);
    }

    public PizzaClonable PizzaClonable() {
        return this.Clonar();
    }

    public PizzaHawaiana PizzaHawaiana(PizzaClonable pizzaClonable) {
        return (PizzaHawaiana) pizzaClonable.Clonar();
    }

    public PizzaHawaiana PizzaHawaiana(Piña piña) {
        return new PizzaHawaiana(tomate, salsaTomate, queso, masa, pollo, piña);
    }
}