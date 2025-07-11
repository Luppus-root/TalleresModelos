package com.beautyathome.backend.pattern.composite;

import com.beautyathome.backend.entity.Profesional;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicioSimple extends ServicioComponent {

    // Relación con Profesional (muchos servicios pueden pertenecer a un profesional)
    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    @Override
    public Double calcularPrecio() {
        return this.getPrecio();
    }

    // Métodos adicionales para coherencia con otros patrones
    public String obtenerDescripcion() {
        return this.getDescripcion();
    }

    public Double obtenerPrecio() {
        return this.getPrecio();
    }

    // Getters y setters explícitos por claridad (además de los generados por Lombok)
    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getDescripcion() {
        return super.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    public Double getPrecio() {
        return super.getPrecio();
    }

    public void setPrecio(Double precio) {
        super.setPrecio(precio);
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
}

