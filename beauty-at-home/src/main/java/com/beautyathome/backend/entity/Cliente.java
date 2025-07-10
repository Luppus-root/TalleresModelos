package com.beautyathome.backend.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ServicioRealizado> serviciosRealizados;

    public void agregarServicioRealizado(ServicioRealizado servicio) {
        this.serviciosRealizados.add(servicio);
    }
}

