package model.pizzas;

import model.base.PizzaClonable;
import model.ingredientes.Masa;
import model.ingredientes.Piña;
import model.ingredientes.Pollo;
import model.ingredientes.Queso;
import model.ingredientes.SalsaTomate;
import model.ingredientes.Tomate;

public class PizzaPollo extends Pizza {

    private Tomate tomate;
    private SalsaTomate salsaTomate;
    private Queso queso;
    private Masa masa;
    private Piña piña;
    private Pollo pollo;

    public PizzaPollo(Tomate tomate, SalsaTomate salsaTomate, Queso queso, Masa masa, Piña piña, Pollo pollo) {
        super();
        this.tomate = tomate;
        this.salsaTomate = salsaTomate;
        this.queso = queso;
        this.masa = masa;
        this.piña = piña;
        this.pollo = pollo;

        this.agregar(tomate);
        this.agregar(salsaTomate);
        this.agregar(queso);
        this.agregar(masa);
        this.agregar(piña);
        this.agregar(pollo);
    }

    @Override
    public String getDescripcion() {
        return "Pizza de Pollo con: " + super.getDescripcion();
    }

    @Override
    public PizzaClonable Clonar() {
        return new PizzaPollo(tomate, salsaTomate, queso, masa, piña, pollo);
    }

    public PizzaClonable PizzaClonable() {
        return this.Clonar();
    }

    public PizzaHawaiana PizzaHawaiana(PizzaClonable pizzaClonable) {
        PizzaPollo cloned = (PizzaPollo) pizzaClonable.Clonar();
        return new PizzaHawaiana(cloned.tomate, cloned.salsaTomate, cloned.queso, cloned.masa, cloned.pollo, cloned.piña);
    }

    public PizzaPollo PizzaPollo() {
        return (PizzaPollo) this.Clonar();
    }
}