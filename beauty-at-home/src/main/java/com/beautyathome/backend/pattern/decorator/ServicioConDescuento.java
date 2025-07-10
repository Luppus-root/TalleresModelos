package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ServicioConDescuento extends ServicioDecorator {

    private double porcentajeDescuento;

    public ServicioConDescuento(ServicioComponent servicioBase, double porcentajeDescuento) {
        super(servicioBase);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public Double calcularPrecio() {
        double original = super.calcularPrecio();
        return original - (original * porcentajeDescuento / 100);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " (Descuento aplicado: " + porcentajeDescuento + "%)";
    }
}
