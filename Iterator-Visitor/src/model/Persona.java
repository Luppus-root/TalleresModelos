package src.model;

import java.util.List;
import src.visitor.PersonaVisitor;

public abstract class Persona implements Comparable<Persona>{
    private String codigo;
    private String nombre;
    private String direccion;
    private List<String> telefonos;

    public Persona(String codigo, String nombre, String direccion, List<String> telefonos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public abstract void aceptar(PersonaVisitor visitor);

    @Override
    public int compareTo(Persona otra) {

        int typeComparison = this.getClass().getSimpleName()
                .compareTo(otra.getClass().getSimpleName());
        if (typeComparison != 0) {
            return typeComparison;
        }
        return this.codigo.compareTo(otra.codigo);
    }
}
