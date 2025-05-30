package src.iterator;

import src.model.Persona;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;

public class AtrasTreeSetPersonaIterator implements PersonaIterator {
    private ListIterator<Persona> iterator;

    public AtrasTreeSetPersonaIterator(TreeSet<Persona> set) {
        ArrayList<Persona> temp = new ArrayList<>(set);
        this.iterator = temp.listIterator(temp.size());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Persona next() {
        throw new UnsupportedOperationException("Iterador solo retrocede.");
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

