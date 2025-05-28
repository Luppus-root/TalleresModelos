

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estudiantes
 */
public class EstudianteIteradorTree implements Iterator<Estudiante> {
    private Iterator<Estudiante> iterator;
    private Notificador notificador;

    public EstudianteIteradorTree(TreeSet<Estudiante> estudiantesTree) {
        this.iterator = estudiantesTree.iterator();
        this.notificador = new Notificador();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Estudiante next() {
        Estudiante estudiante = iterator.next();
        if (estudiante.getNombre() == null || estudiante.getDireccion() == null || estudiante.getTelefonos().isEmpty()) {
            notificador.enviarMensaje(estudiante.getCodigo());
        }
        return estudiante;
    }
}