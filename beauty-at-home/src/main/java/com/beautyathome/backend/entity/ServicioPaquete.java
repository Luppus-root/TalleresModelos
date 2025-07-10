package com.beautyathome.backend.entity;
import jakarta.persistence.*;
import lombok.*;


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
    private Double precio;

    @ManyToMany
    private List<ServicioSimple> servicios;

    @ManyToOne
    private Profesional profesional;

    public void agregarServicio(ServicioSimple servicio) {
        servicios.add(servicio);
        precio += servicio.getPrecio();
    }

    public void quitarServicio(ServicioSimple servicio) {
        if (servicios.remove(servicio)) {
            precio -= servicio.getPrecio();
        }
    }
}

