package com.beautyathome.backend.pattern.composite;
import com.beautyathome.backend.entity.Profesional;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicioSimple extends ServicioComponent {

    @ElementCollection
    private List<String> imagenes;

    @ManyToOne
    private Profesional profesional;

    @Override
    public Double calcularPrecio() {
        return this.precio;
    }
}

