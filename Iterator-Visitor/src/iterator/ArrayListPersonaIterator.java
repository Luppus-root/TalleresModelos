package src.iterator;

import src.model.Persona;
import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListPersonaIterator implements PersonaIterator {
    private ListIterator<Persona> iterator;

    public  ArrayListPersonaIterator(ArrayList<Persona> lista) {
        this.iterator = lista.listIterator();
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