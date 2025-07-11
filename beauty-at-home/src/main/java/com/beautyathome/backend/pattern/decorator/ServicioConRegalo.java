package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ServicioConRegalo extends ServicioDecorator {
    private String regalo;

    public ServicioConRegalo(ServicioComponent servicio, String regalo) {
        super(servicio);
        this.regalo = regalo;
    }

    @Override
    public Double calcularPrecio() {
        // El precio no cambia, solo se añade el regalo
        return servicioCompuesto.calcularPrecio();
    }

    @Override
    public String getDescripcion() {
        return servicioCompuesto.getDescripcion() + " | Incluye regalo: " + regalo;
    }
}
