import builder.*;
import model.pizzas.*;
import model.base.PizzaClonable;

public class PizzaApplication {
    public static void main(String[] args) {
        // Usando el patrón Builder para crear pizzas
        Chef chefHawaiana = new ChefPizzaHawaiana();
        Chef chefPollo = new ChefPizzaPollo();

        Cliente cliente = new Cliente(chefHawaiana);

        // Creando una pizza hawaiana
        System.out.println("Creando una Pizza Hawaiana original:");
        PizzaHawaiana pizzaHawaiana = (PizzaHawaiana) cliente.construirPizzaHawaiana(
                "integral", 5.0,
                "mozzarella", 3.0,
                "dulce", 2.5,
                "cherry", 1.8,
                2.0
        );
        System.out.println(pizzaHawaiana.getDescripcion());

        // Cambiando el chef para crear una pizza de pollo
        cliente.setChef(chefPollo);

        // Creando una pizza de pollo
        System.out.println("\nCreando una Pizza de Pollo original:");
        PizzaPollo pizzaPollo = (PizzaPollo) cliente.construirPizzaPollo(
                "normal", 4.0,
                "cheddar", 3.5,
                "desmenuzado", 4.5,
                "italiano", 2.0,
                1.5
        );
        System.out.println(pizzaPollo.getDescripcion());

        /*+
        // Usando el patrón Prototype para clonar pizzas
        System.out.println("\nClonando la Pizza Hawaiana:");
        PizzaClonable pizzaHawaianaClon = pizzaHawaiana.clonar();
        System.out.println(((PizzaHawaiana)pizzaHawaianaClon).getDescripcion());

        System.out.println("\nClonando la Pizza de Pollo:");
        PizzaClonable pizzaPolloClon = pizzaPollo.clonar();
        System.out.println(((PizzaPollo)pizzaPolloClon).getDescripcion());

        // Demostrando que la pizza clonada es diferente instancia pero igual contenido
        System.out.println("\nComparando instancias de Pizza Hawaiana:");
        System.out.println("Son la misma instancia? " + (pizzaHawaiana == pizzaHawaianaClon));
        System.out.println("Tienen la misma descripción? " + pizzaHawaiana.getDescripcion().equals(((PizzaHawaiana)pizzaHawaianaClon).getDescripcion()));
    */
    }
}