package builder;

import model.ingredientes.*;
import model.pizzas.PizzaHawaiana;

public class ChefPizzaHawaiana implements Chef {
    private PizzaHawaiana pizzaHawaiana;

    @Override
    public void crearComida() {
        pizzaHawaiana = new PizzaHawaiana();
    }

    @Override
    public void agregarMasa(String nombre, double precio) {
        Masa masa = new Masa(nombre, precio);
        pizzaHawaiana.setMasa(masa);
        pizzaHawaiana.agregar(masa);
    }

    @Override
    public void agregarQueso(String nombre, double precio) {
        Queso queso = new Queso(nombre, precio);
        pizzaHawaiana.setQueso(queso);
        pizzaHawaiana.agregar(queso);
    }


    public void agregarPiña(String nombre, double precio) {
        Piña piña = new Piña(nombre, precio);
        pizzaHawaiana.setPiña(piña);
        pizzaHawaiana.agregar(piña);
    }

    @Override
    public void agregarPollo(String nombrePollo, double precioPollo) {}

    @Override
    public void agregarTomate(String nombre, double precio) {
        Tomate tomate = new Tomate(nombre, precio);
        pizzaHawaiana.setTomate(tomate);
    }

    @Override
    public void agregarSalsaTomate(String nombre, double cantidadTomate) {
        if (pizzaHawaiana.tomate != null) {
            SalsaTomate salsaTomate = new SalsaTomate(pizzaHawaiana.tomate, cantidadTomate);
            pizzaHawaiana.setSalsaTomate(salsaTomate);
            pizzaHawaiana.agregar(salsaTomate);
        }
    }

    @Override
    public PizzaHawaiana finalizarComida() {
        return pizzaHawaiana;
    }
}