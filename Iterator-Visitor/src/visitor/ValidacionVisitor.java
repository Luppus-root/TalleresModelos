package visitor;
import model.Estudiante;

public class ValidacionVisitor implements EstudianteVisitor {

    @Override
    public void visit(Estudiante estudiante) {
        boolean completo = true;

        if (estudiante.getCodigo() == null || estudiante.getCodigo().isEmpty()) {
            System.out.println("Falta código en estudiante.");
            completo = false;
        }

        if (estudiante.getNombre() == null || estudiante.getNombre().isEmpty()) {
            System.out.println("Falta nombre en estudiante con código: " + estudiante.getCodigo());
            completo = false;
        }

        if (estudiante.getDireccion() == null || estudiante.getDireccion().isEmpty()) {
            System.out.println("Falta dirección en estudiante con código: " + estudiante.getCodigo());
            completo = false;
        }

        if (estudiante.getTelefonos() == null || estudiante.getTelefonos().isEmpty()) {
            System.out.println("Faltan teléfonos en estudiante con código: " + estudiante.getCodigo());
            completo = false;
        }

        if (completo) {
            System.out.println("Estudiante válido: " + estudiante.getCodigo());
        }
    }
}

