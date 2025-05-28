import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import iterator.ArrayListEstudianteIterator;
import iterator.EstudianteIterator;
import iterator.TreeSetEstudianteIterator;
import model.Estudiante;
import visitor.EstudianteVisitor;
import visitor.ValidacionVisitor;
import java.util.*;

public class AppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear estudiantes
        Estudiante e1 = new Estudiante("001", "Ana", "cra 90-12", Arrays.asList("123456"));
        Estudiante e2 = new Estudiante("002", "Luis", "", Arrays.asList("789123"));
        Estudiante e3 = new Estudiante("003", null, "Calle 123", Arrays.asList("555555", "666666"));
        Estudiante e4 = new Estudiante("004", "María", "Calle 80", null);

        ArrayList<Estudiante> lista = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
        TreeSet<Estudiante> set = new TreeSet<>(lista);

        EstudianteVisitor validador = new ValidacionVisitor();


        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Recorrer ArrayList hacia adelante");
            System.out.println("2. Recorrer ArrayList hacia atrás");
            System.out.println("3. Recorrer TreeSet hacia adelante");
            System.out.println("4. Recorrer TreeSet hacia atrás");
            System.out.println("0. Salir");
            System.out.print("> ");
            int opcion = scanner.nextInt();

            EstudianteIterator iterator;

            switch (opcion) {
                case 1:
                    iterator = new ArrayListEstudianteIterator(lista);
                    System.out.println("\n→ ArrayList (adelante):");
                    while (iterator.hasNext()) validador.visit(iterator.next());
                    break;

                case 2:
                    iterator = new ArrayListEstudianteIterator(lista);
                    while (iterator.hasNext()) iterator.next();
                    System.out.println("\n← ArrayList (atrás):");
                    while (iterator.hasPrevious()) validador.visit(iterator.previous());
                    break;

                case 3:
                    iterator = new TreeSetEstudianteIterator(set);
                    System.out.println("\n→ TreeSet (adelante):");
                    while (iterator.hasNext()) validador.visit(iterator.next());
                    break;

                case 4:
                    iterator = new TreeSetEstudianteIterator(set);
                    while (iterator.hasNext()) iterator.next();
                    System.out.println("\n← TreeSet (atrás):");
                    while (iterator.hasPrevious()) validador.visit(iterator.previous());
                    break;

                case 0:
                    System.out.println("Finalizado");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}


