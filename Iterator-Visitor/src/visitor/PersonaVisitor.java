package src.visitor;

import src.model.Docente;
import src.model.Estudiante;

public interface PersonaVisitor {
    void visit(Docente docente);
    void visit(Estudiante estudiante);
}