package src.visitor;

import src.model.Docente;
import src.model.Estudiante;

public class ValidacionVisitor implements PersonaVisitor  {

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

    @Override
    public void visit(Docente docente) {
        boolean completo = true;

        if (docente.getCodigo() == null || docente.getCodigo().isEmpty()) {
            System.out.println("Falta código en docente.");
            completo = false;
        } else if (docente.getCodigo().length() > 4) {
            System.out.println("El código del docente " + docente.getCodigo() + " no puede tener más de 4 dígitos");
            completo = false;
        }

        if (docente.getNombre() == null || docente.getNombre().isEmpty()) {
            System.out.println("Falta nombre en docente con código: " + docente.getCodigo());
            completo = false;
        }

        if (docente.getDireccion() == null || docente.getDireccion().isEmpty()) {
            System.out.println("Falta dirección en docente con código: " + docente.getCodigo());
            completo = false;
        }

        if (docente.getTelefonos() == null || docente.getTelefonos().isEmpty()) {
            System.out.println("Faltan teléfonos en docente con código: " + docente.getCodigo());
            completo = false;
        }

        if (completo) {
            System.out.println("Docente válido: " + docente.getCodigo());
        }
    }
}


