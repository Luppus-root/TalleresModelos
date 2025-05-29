package src.model;

import src.visitor.PersonaVisitor;

import java.util.List;

public class Docente extends Persona implements Comparable<Persona> {
    public Docente(String codigo, String nombre, String direccion, List<String> telefonos) {
        super(codigo, nombre, direccion, telefonos);
    }

    @Override
    public String toString() {
        return "Docente{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefonos=" + getTelefonos() + '}';
    }

    @Override
    public void aceptar(PersonaVisitor visitor) {
        visitor.visit(this);
    }

}


