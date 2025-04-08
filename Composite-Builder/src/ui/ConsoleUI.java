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

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada no válida. Intente con un número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String seleccionarOpcion(String tipo, String[] opciones) {
        System.out.println("Seleccione tipo de " + tipo + ":");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        int seleccion = getUserInput("Opción: ");
        while (seleccion < 1 || seleccion > opciones.length) {
            System.out.print("Opción inválida. Intente nuevamente: ");
            seleccion = getUserInput("");
        }

        return opciones[seleccion - 1];
    }

    private static void crearPizzaHawaiana() {
        System.out.println("\n--- Creando Pizza Hawaiana ---");
        cliente.setChef(chefHawaiana);

        String masa = seleccionarOpcion("masa", new String[]{"Integral", "Clásica"});
        String queso = seleccionarOpcion("queso", new String[]{"Mozzarella", "Cheddar"});
        String piña = seleccionarOpcion("piña", new String[]{"Natural", "Enlatada"});
        String tomate = seleccionarOpcion("tomate", new String[]{"Cherry", "Roma"});

        pizzaHawaiana = (PizzaHawaiana) cliente.construirPizzaHawaiana(
                masa, 5.0,
                queso, 3.0,
                piña, 2.5,
                tomate, 1.8,
                2.0
        );

        System.out.println(pizzaHawaiana.getDescripcion());
        System.out.println("💰 Precio total: $" + pizzaHawaiana.getPrecioUnitario());
    }

    private static void crearPizzaPollo() {
        System.out.println("\n--- Creando Pizza de Pollo ---");
        cliente.setChef(chefPollo);

        String masa = seleccionarOpcion("masa", new String[]{"Normal", "Fina"});
        String queso = seleccionarOpcion("queso", new String[]{"Cheddar", "Mozzarella"});
        String pollo = seleccionarOpcion("pollo", new String[]{"Desmenuzado", "Tiras"});
        String tomate = seleccionarOpcion("tomate", new String[]{"Cherry", "Roma"});

        pizzaPollo = (PizzaPollo) cliente.construirPizzaPollo(
                masa, 4.0,
                queso, 3.5,
                pollo, 4.5,
                tomate, 2.0,
                1.5
        );

        System.out.println(pizzaPollo.getDescripcion());
        System.out.println("💰 Precio total: $" + pizzaPollo.getPrecioUnitario());
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
