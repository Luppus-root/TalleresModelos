package src.iterator;

import src.model.Persona;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;


public class AdelanteTreeSetPersonaIterator implements PersonaIterator {
    private ListIterator<Persona> iterator;

    public AdelanteTreeSetPersonaIterator(TreeSet<Persona> set) {
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
        return false;
    }

    @Override
    public Persona previous() {
        throw new UnsupportedOperationException("Iterador solo avanza hacia adelante.");
    }
}
