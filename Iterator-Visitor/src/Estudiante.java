
import java.util.ArrayList;

/**
 *
 * @author estudiantes
 */
public class Estudiante {
    
    private String codigo;
    private String nombre;
    private String direccion;
    private ArrayList<Integer> telefonos;
    
    

    public Estudiante(String codigo, String nombre, String direccion) {
        
        this.codigo= codigo;
        this.nombre= nombre;
        this.direccion= direccion;
        this.telefonos = new ArrayList<Integer>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Integer> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Integer> telefonos) {
        this.telefonos = telefonos;
    }
 

}
