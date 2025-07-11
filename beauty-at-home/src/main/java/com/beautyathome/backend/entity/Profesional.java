package com.beautyathome.backend.entity;

import com.beautyathome.backend.pattern.builder.ServicioBuilder;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profesional extends Usuario {

    private String resumen;
    private String fotoUrl;

    @ManyToOne
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "profesional_zona")
    private List<ZonaCobertura> zonasCobertura;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
    private List<ServicioSimple> serviciosSimples;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
    private List<ServicioPaquete> serviciosPaquete;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
    private List<Disponibilidad> disponibilidad;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
    private List<ServicioRealizado> serviciosRealizados;



    public void agregarZona(ZonaCobertura zona) {
        this.zonasCobertura.add(zona);
    }

    public void agregarDisponibilidad(Disponibilidad slot) {
        this.disponibilidad.add(slot);
    }
}
