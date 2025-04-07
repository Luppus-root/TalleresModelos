package builder;

import model.ingredientes.Masa;
import model.ingredientes.Piña;
import model.ingredientes.Pollo;
import model.ingredientes.Queso;
import model.ingredientes.SalsaTomate;
import model.ingredientes.Tomate;
import model.pizzas.PizzaHawaiana;

public class ChefPizzaHawaiana extends Chef {

    private PizzaHawaiana pizzaHawaiana;
    private Tomate tomate;
    private Pollo pollo;
    private Piña piña;
    private Masa masa;
    private Queso queso;
    private SalsaTomate salsaTomate;

    public ChefPizzaHawaiana() {

    }

    @Override
    public String crearComida() {
        if (tomate != null && pollo != null && piña != null && masa != null && queso != null && salsaTomate != null) {
            pizzaHawaiana = new PizzaHawaiana(tomate, salsaTomate, queso, masa, pollo, piña);
            return pizzaHawaiana.getDescripcion();
        } else {
            return "No se puede crear la pizza hawaiana, faltan ingredientes.";
        }
    }

    @Override
    public void agregarPollo(String nombre, double precio) {
        this.pollo = new Pollo(nombre, precio);
    }

    @Override
    public void agregarPiña(String nombre, double precio) {
        this.piña = new Piña(nombre, precio);
    }

    @Override
    public void agregarMasa(String nombre, double precio) {
        this.masa = new Masa(nombre, precio);
    }

    @Override
    public void agregarQueso(String nombre, double precio) {
        this.queso = new Queso(nombre, precio);
    }

    @Override
    public void agregarTomate(String nombre, double precio) {
        this.tomate = new Tomate(nombre, precio);
    }

    @Override
    public void agregarSalsaTomate(String nombre, double cantidadTomate) {
        if (this.tomate != null) {
            this.salsaTomate = new SalsaTomate(this.tomate, cantidadTomate);
        }
    }

    public PizzaHawaiana finalizarComida() {
        if (pizzaHawaiana == null) {
            crearComida();
        }
        return pizzaHawaiana;
    }
}