package src.iterator;
import src.model.Persona;

public interface PersonaIterator {
    boolean hasNext();
    Persona next();
    boolean hasPrevious();
    Persona previous();
}