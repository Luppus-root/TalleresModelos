
import java.util.*;

/**
 *
 * @author estudiantes
 */
public class IteradorMain {
    public static void main(String[] args) {


        ArrayList<Estudiante> lista = new ArrayList<>();
        TreeSet<Estudiante> tree = new TreeSet<>(Comparator.comparing(Estudiante::getCodigo));


        Estudiante e1 = new Estudiante("001", null, "Calle 1");
        e1.getTelefonos().add(123456789);
        lista.add(e1);

        Estudiante e2 = new Estudiante("002", null, "Calle 2");
        lista.add(e2);

        Estudiante e3 = new Estudiante("003", "Luis", null);
        lista.add(e3);

        Estudiante e4 = new Estudiante("004", "Marta", "Calle 4");
        lista.add(e4);

        Estudiante e5 = new Estudiante("005", "Pedro", "Calle 5");
        e5.getTelefonos().add(111111111);
        lista.add(e5);

        Estudiante e6 = new Estudiante("006", "Sara", "Calle 6");
        e6.getTelefonos().add(222222222);
        lista.add(e6);

        Estudiante e7 = new Estudiante("007", null, null);
        lista.add(e7);

        Estudiante e8 = new Estudiante("008", "Lucía", "Calle 8");
        lista.add(e8);

        Estudiante e9 = new Estudiante("009", "Diego", "Calle 9");
        e9.getTelefonos().add(999999999);

        lista.add(e9);

        Estudiante e10 = new Estudiante("010", "Elena", "Calle 10");
        lista.add(e10);

        tree.addAll(lista);


        System.out.println("Iterando Array:");
        EstudianteIteradorArray iterArray = new EstudianteIteradorArray(lista);
        while (iterArray.hasNext()) {
            iterArray.next();
        }


        System.out.println("Iterando Tree:");
        EstudianteIteradorTree iterTree = new EstudianteIteradorTree(tree);
        while (iterTree.hasNext()) {
            iterTree.next();
        }
}

}