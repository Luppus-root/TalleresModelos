package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;

public class ServicioDecoratorFactory {

    public static ServicioComponent aplicarDescuento(ServicioComponent base, double porcentaje) {
        return new ServicioConDescuento(base, porcentaje);
    }

    public static ServicioComponent agregarRegalo(ServicioComponent base, String regalo) {
        return new ServicioConRegalo(base, regalo);
    }

    public static ServicioComponent encadenarDecoradores(ServicioComponent base, double descuento, String regalo) {
        ServicioComponent conDescuento = aplicarDescuento(base, descuento);
        return agregarRegalo(conDescuento, regalo);
    }
}
