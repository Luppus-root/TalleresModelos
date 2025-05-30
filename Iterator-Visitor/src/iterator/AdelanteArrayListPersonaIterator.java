package src.iterator;

import src.model.Persona;
import java.util.ArrayList;
import java.util.ListIterator;

public class AdelanteArrayListPersonaIterator implements PersonaIterator {
    private ListIterator<Persona> iterator;

    public AdelanteArrayListPersonaIterator(ArrayList<Persona> lista) {
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
        return false;
    }

    @Override
    public Persona previous() {
        throw new UnsupportedOperationException("Iterador solo avanza hacia adelante.");
    }
}