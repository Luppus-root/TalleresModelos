package iterator;
import model.Estudiante;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListEstudianteIterator implements EstudianteIterator {
    private ListIterator<Estudiante> iterator;

    public ArrayListEstudianteIterator(ArrayList<Estudiante> lista) {
        this.iterator = lista.listIterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Estudiante next() {
        return iterator.next();
    }

    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    @Override
    public Estudiante previous() {
        return iterator.previous();
    }
}


