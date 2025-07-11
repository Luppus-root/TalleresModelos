package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ServicioDecorator extends ServicioComponent {
    protected ServicioComponent servicioCompuesto;

    public ServicioDecorator(ServicioComponent servicio) {
        super();
        this.servicioCompuesto = servicio;
    }


    @Override
    public abstract Double calcularPrecio();

    @Override
    public String getNombre() {
        return servicioCompuesto.getNombre();
    }

    @Override
    public String getDescripcion() {
        return servicioCompuesto.getDescripcion();
    }

    @Override
    public Double getPrecio() {
        return servicioCompuesto.getPrecio();
    }
}
