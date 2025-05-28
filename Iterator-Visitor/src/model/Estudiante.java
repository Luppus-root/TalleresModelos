package model;
import java.util.List;

public class Estudiante implements Comparable<Estudiante> {
    private String codigo;
    private String nombre;
    private String direccion;
    private List<String> telefonos;

    public Estudiante(String codigo, String nombre, String direccion, List<String> telefonos) {
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

    @Override
    public int compareTo(Estudiante otro) {
        return this.codigo.compareTo(otro.codigo); // Para TreeSet
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonos=" + telefonos + '}';
    }
}

