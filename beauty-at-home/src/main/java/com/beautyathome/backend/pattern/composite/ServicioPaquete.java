package com.beautyathome.backend.pattern.composite;
import com.beautyathome.backend.entity.Profesional;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicioPaquete extends ServicioComponent {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "paquete_servicios")
    private List<ServicioSimple> servicios = new ArrayList<>();

    @ManyToOne
    private Profesional profesional;

    @Override
    public Double calcularPrecio() {
        return servicios.stream()
                .mapToDouble(ServicioSimple::getPrecio)
                .sum();
    }

    public void agregarServicio(ServicioSimple servicio) {
        servicios.add(servicio);
    }

    public void quitarServicio(ServicioSimple servicio) {
        servicios.remove(servicio);
    }
}


