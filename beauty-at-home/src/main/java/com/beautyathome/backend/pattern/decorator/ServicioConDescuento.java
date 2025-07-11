package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ServicioConDescuento extends ServicioDecorator {
    private Double descuento; // porcentaje entre 0 y 1 (ej: 0.2 para 20%)

    public ServicioConDescuento(ServicioComponent servicio, Double descuento) {
        super(servicio);
        this.descuento = descuento;
    }

    @Override
    public Double calcularPrecio() {
        Double precioBase = servicioCompuesto.calcularPrecio();
        return precioBase - (precioBase * descuento);
    }

    @Override
    public String getDescripcion() {
        return servicioCompuesto.getDescripcion() + " | Descuento aplicado: " + (int)(descuento * 100) + "%";
    }
}
