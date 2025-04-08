package builder;

import model.ingredientes.*;
import model.pizzas.PizzaPollo;

public class ChefPizzaPollo implements Chef {
    private PizzaPollo pizzaPollo;

    @Override
    public void crearComida() {
        pizzaPollo = new PizzaPollo();
    }

    @Override
    public void agregarMasa(String nombre, double precio) {
        Masa masa = new Masa(nombre, precio);
        pizzaPollo.setMasa(masa);
        pizzaPollo.agregar(masa);
    }

    @Override
    public void agregarQueso(String nombre, double precio) {
        Queso queso = new Queso(nombre, precio);
        pizzaPollo.setQueso(queso);
        pizzaPollo.agregar(queso);
    }

    public void agregarPollo(String nombre, double precio) {
        Pollo pollo = new Pollo(nombre, precio);
        pizzaPollo.setPollo(pollo);
        pizzaPollo.agregar(pollo);
    }

    @Override
    public void agregarTomate(String nombre, double precio) {
        Tomate tomate = new Tomate(nombre, precio);
        pizzaPollo.setTomate(tomate);
    }

    @Override
    public void agregarSalsaTomate(String nombre, double cantidadTomate) {
        if (pizzaPollo.tomate != null) {
            SalsaTomate salsaTomate = new SalsaTomate(pizzaPollo.tomate, cantidadTomate);
            pizzaPollo.setSalsaTomate(salsaTomate);
            pizzaPollo.agregar(salsaTomate);
        }
    }

    @Override
    public PizzaPollo finalizarComida() {
        return pizzaPollo;
    }

    @Override
    public void agregarPiña(String nombrePiña, double precioPiña) {}
}