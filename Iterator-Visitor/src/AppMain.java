package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.Scanner;

import src.iterator.*;
import src.model.*;
import src.visitor.ValidacionVisitor;

public class AppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estudiante e1 = new Estudiante("001", "Duvan", "Cra 90-12", Arrays.asList("123456"));
        Estudiante e2 = new Estudiante("002", "Mendi", "", Arrays.asList("789123"));
        Estudiante e3 = new Estudiante("003", null, "Calle 123", Arrays.asList("555555", "666666"));
        Estudiante e4 = new Estudiante("004", "Luppus", "Calle 80", null);

        Docente d1 = new Docente("1", "Sebastian", "Calle 40", Arrays.asList("111111"));
        Docente d2 = new Docente("232", "", "Calle 34", null);
        Docente d3 = new Docente("12", "Deicy", null, Arrays.asList("222222"));
        Docente d4 = new Docente("1245453545", "Isabel", "Cra 10", Arrays.asList("333333"));

        ArrayList<Persona> listaPersonas = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, d1, d2, d3, d4));
        TreeSet<Persona> setPersonas = new TreeSet<>(listaPersonas);

        ValidacionVisitor validador = new ValidacionVisitor();

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Recorrer ArrayList hacia adelante");
            System.out.println("2. Recorrer ArrayList hacia atrás");
            System.out.println("3. Recorrer TreeSet hacia adelante");
            System.out.println("4. Recorrer TreeSet hacia atrás");
            System.out.println("0. Salir");
            System.out.print("> ");
            int opcion = scanner.nextInt();

            PersonaIterator iterator;

            switch (opcion) {
                case 1:
                    iterator = new ArrayListPersonaIterator(listaPersonas);
                    System.out.println("\n→ ArrayList (adelante):");
                    while (iterator.hasNext()) {
                        Persona persona = iterator.next();
                        persona.aceptar(validador);
                    }
                    break;

                case 2:
                    iterator = new ArrayListPersonaIterator(listaPersonas);

                    while (iterator.hasNext()) iterator.next();
                    System.out.println("\n← ArrayList (atrás):");
                    while (iterator.hasPrevious()) {
                        Persona persona = iterator.previous();
                        persona.aceptar(validador);
                    }
                    break;

                case 3:
                    iterator = new TreeSetPersonaIterator(setPersonas);
                    System.out.println("\n→ TreeSet (adelante):");
                    while (iterator.hasNext()) {
                        Persona persona = iterator.next();
                        persona.aceptar(validador);
                    }
                    break;

                case 4:
                    iterator = new TreeSetPersonaIterator(setPersonas);

                    while (iterator.hasNext()) iterator.next();
                    System.out.println("\n← TreeSet (atrás):");
                    while (iterator.hasPrevious()) {
                        Persona persona = iterator.previous();
                        persona.aceptar(validador);
                    }
                    break;

                case 0:
                    System.out.println("Finalizado");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}