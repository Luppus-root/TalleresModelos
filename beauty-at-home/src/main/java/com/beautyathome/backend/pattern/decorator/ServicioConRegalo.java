package com.beautyathome.backend.pattern.decorator;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ServicioConRegalo extends ServicioDecorator {

    private String detalleRegalo;

    public ServicioConRegalo(ServicioComponent servicioBase, String detalleRegalo) {
        super(servicioBase);
        this.detalleRegalo = detalleRegalo;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Regalo: " + detalleRegalo;
    }
}

