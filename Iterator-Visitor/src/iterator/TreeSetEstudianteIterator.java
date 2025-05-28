package iterator;
import model.Estudiante;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;

public class TreeSetEstudianteIterator implements EstudianteIterator {
    private ListIterator<Estudiante> iterator;

    public TreeSetEstudianteIterator(TreeSet<Estudiante> set) {
        ArrayList<Estudiante> temp = new ArrayList<>(set);
        this.iterator = temp.listIterator();
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

