package src.iterator;
import src.model.Persona;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;

public class TreeSetPersonaIterator implements PersonaIterator  {
    private ListIterator<Persona> iterator;

    public TreeSetPersonaIterator(TreeSet<Persona> set) {
        ArrayList<Persona> temp = new ArrayList<>(set);
        this.iterator = temp.listIterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Persona next() {
        return iterator.next();
    }

    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    @Override
    public Persona previous() {
        return iterator.previous();
    }
}

