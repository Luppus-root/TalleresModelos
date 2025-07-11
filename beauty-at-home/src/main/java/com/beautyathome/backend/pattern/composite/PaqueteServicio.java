package com.beautyathome.backend.pattern.composite;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PaqueteServicio extends ServicioComponent {

    @ManyToMany
    private List<ServicioComponent> servicios = new ArrayList<>();

    public void agregar(ServicioComponent servicio) {
        servicios.add(servicio);
    }

    public void eliminar(ServicioComponent servicio) {
        servicios.remove(servicio);
    }

    public List<ServicioComponent> obtenerServicios() {
        return servicios;
    }

    @Override
    public Double calcularPrecio() {
        double total = 0.0;
        for (ServicioComponent s : servicios) {
            total += s.calcularPrecio();
        }
        return total;
    }
}


