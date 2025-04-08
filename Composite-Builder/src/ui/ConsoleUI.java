package ui;

import builder.*;
import model.pizzas.*;
import model.base.PizzaClonable;

import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);

    private static Chef chefHawaiana = new ChefPizzaHawaiana();
    private static Chef chefPollo = new ChefPizzaPollo();
    private static Cliente cliente = new Cliente(chefHawaiana);

    private static PizzaHawaiana pizzaHawaiana;
    private static PizzaPollo pizzaPollo;
    private static PizzaClonable pizzaHawaianaClon;
    private static PizzaClonable pizzaPolloClon;

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("     Bienvenido a la Aplicación de Pizzas     ");
        System.out.println("=============================================\n");

        boolean exit = false;

        while (!exit) {
            showMenu();
            int option = getUserInput("Seleccione una opción: ");

            switch (option) {
                case 1 -> crearPizzaHawaiana();
                case 2 -> crearPizzaPollo();
                case 3 -> clonarPizzaHawaiana();
                case 4 -> clonarPizzaPollo();
                case 5 -> compararInstancias();
                case 6 -> limpiarConsola();
                case 0 -> {
                    System.out.println("\nSaliendo de la aplicación. ¡Gracias por usarla!");
                    exit = true;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

            if (!exit) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // espera confirmación
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n----- Menú Principal -----");
        System.out.println("1. Crear Pizza Hawaiana");
        System.out.println("2. Crear Pizza de Pollo");
        System.out.println("3. Clonar Pizza Hawaiana");
        System.out.println("4. Clonar Pizza de Pollo");
        System.out.println("5. Comparar Instancias");
        System.out.println("6. Limpiar Consola");
        System.out.println("0. Salir");
    }

    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. Intente con un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void crearPizzaHawaiana() {
        System.out.println("\n--- Creando Pizza Hawaiana ---");
        cliente.setChef(chefHawaiana);
        pizzaHawaiana = (PizzaHawaiana) cliente.construirPizzaHawaiana(
                "integral", 5.0,
                "mozzarella", 3.0,
                "dulce", 2.5,
                "cherry", 1.8,
                2.0
        );
        System.out.println(pizzaHawaiana.getDescripcion());
    }

    private static void crearPizzaPollo() {
        System.out.println("\n--- Creando Pizza de Pollo ---");
        cliente.setChef(chefPollo);
        pizzaPollo = (PizzaPollo) cliente.construirPizzaPollo(
                "normal", 4.0,
                "cheddar", 3.5,
                "desmenuzado", 4.5,
                "italiano", 2.0,
                1.5
        );
        System.out.println(pizzaPollo.getDescripcion());
    }

    private static void clonarPizzaHawaiana() {
        if (pizzaHawaiana == null) {
            System.out.println("\nDebe crear primero una Pizza Hawaiana.");
            return;
        }

        System.out.println("\n--- Clonando Pizza Hawaiana ---");
        pizzaHawaianaClon = pizzaHawaiana.clonar();
        System.out.println(((PizzaHawaiana) pizzaHawaianaClon).getDescripcion());
    }

    private static void clonarPizzaPollo() {
        if (pizzaPollo == null) {
            System.out.println("\nDebe crear primero una Pizza de Pollo.");
            return;
        }

        System.out.println("\n--- Clonando Pizza de Pollo ---");
        pizzaPolloClon = pizzaPollo.clonar();
        System.out.println(((PizzaPollo) pizzaPolloClon).getDescripcion());
    }

    private static void compararInstancias() {
        if (pizzaHawaiana == null || pizzaHawaianaClon == null) {
            System.out.println("\nDebe crear y clonar una Pizza Hawaiana primero.");
            return;
        }

        System.out.println("\n--- Comparando Instancias de Pizza Hawaiana ---");
        boolean mismaInstancia = pizzaHawaiana == pizzaHawaianaClon;
        boolean mismaDescripcion = pizzaHawaiana.getDescripcion().equals(
                ((PizzaHawaiana) pizzaHawaianaClon).getDescripcion());

        System.out.println("¿Son la misma instancia? " + mismaInstancia);
        System.out.println("¿Tienen la misma descripción? " + mismaDescripcion);
    }

    private static void limpiarConsola() {
        for (int i = 0; i < 50; i++) System.out.println(); // simulación de limpieza
        System.out.println("Consola limpiada.");
    }
}
