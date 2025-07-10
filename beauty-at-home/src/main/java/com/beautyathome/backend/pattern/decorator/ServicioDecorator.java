package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ServicioDecorator extends ServicioComponent {

    protected ServicioComponent servicioBase;

    @Override
    public String getNombre() {
        return servicioBase.getNombre();
    }

    @Override
    public String getDescripcion() {
        return servicioBase.getDescripcion();
    }

    @Override
    public Double getPrecio() {
        return servicioBase.getPrecio();
    }

    @Override
    public Long getId() {
        return servicioBase.getId();
    }

    @Override
    public Double calcularPrecio() {
        return servicioBase.calcularPrecio();
    }
}


