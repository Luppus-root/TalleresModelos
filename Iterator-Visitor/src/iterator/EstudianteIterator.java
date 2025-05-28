package iterator;
import model.Estudiante;

public interface EstudianteIterator {
    boolean hasNext();
    Estudiante next();

    boolean hasPrevious();
    Estudiante previous();
}


