

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estudiantes
 */
public class EstudianteIteradorArray implements Iterator<Estudiante>{

  private ArrayList<Estudiante> estudiantesArray;
  private int posicionActual;
  private Notificador notificador;
  
  
  public EstudianteIteradorArray(ArrayList<Estudiante> estudiantesArray) {
      
      this.posicionActual = 0;
      this.estudiantesArray = estudiantesArray;
      this.notificador = new Notificador();

  }
  
    public boolean hasNext() {
        
        return this.posicionActual < estudiantesArray.size();
    
    }

    @Override
    public Estudiante next() {

        Estudiante estudiante = estudiantesArray.get(posicionActual++);

        if (estudiante.getNombre() == null || estudiante.getDireccion() == null || estudiante.getTelefonos().isEmpty()) {
            notificador.enviarMensaje(estudiante.getCodigo());
        }

        return estudiante;
    }
    
}
