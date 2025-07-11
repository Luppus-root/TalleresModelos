package com.beautyathome.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicioPaquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio = 0.0;

    @ManyToMany
    @JoinTable(
            name = "paquete_servicio_servicio",
            joinColumns = @JoinColumn(name = "paquete_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<ServicioSimple> servicios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    public void agregarServicio(ServicioSimple servicio) {
        if (servicio != null && !servicios.contains(servicio)) {
            servicios.add(servicio);
            if (precio == null) {
                precio = 0.0;
            }
            precio += servicio.getPrecio() != null ? servicio.getPrecio() : 0.0;
        }
    }

    public void quitarServicio(ServicioSimple servicio) {
        if (servicios.remove(servicio)) {
            if (precio == null) {
                precio = 0.0;
            }
            precio -= servicio.getPrecio() != null ? servicio.getPrecio() : 0.0;
        }
    }
}
