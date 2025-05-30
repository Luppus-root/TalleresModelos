package src.iterator;

import src.model.Persona;
import java.util.ArrayList;
import java.util.ListIterator;

public class AtrasArrayListPersonaIterator implements PersonaIterator {
    private ListIterator<Persona> iterator;

    public AtrasArrayListPersonaIterator(ArrayList<Persona> lista) {
        this.iterator = lista.listIterator(lista.size());
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
