package src.model;

import src.visitor.PersonaVisitor;

import java.util.List;

public class Estudiante extends Persona implements Comparable<Persona> {

    public Estudiante(String codigo, String nombre, String direccion, List<String> telefonos) {
        super(codigo, nombre, direccion, telefonos);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
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