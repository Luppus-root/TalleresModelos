package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.entity.ProfesionalEstandar;
import com.beautyathome.backend.entity.ProfesionalPatrocinado;
import org.springframework.stereotype.Component;

@Component
public class ProfesionalEstandarFactory implements ProfesionalFactory {

    @Override
    public ProfesionalEstandar crearProfesionalEstandar() {
        return new ProfesionalEstandar();
    }

    @Override
    public ProfesionalPatrocinado crearProfesionalPatrocinado() {
        throw new UnsupportedOperationException("No soportado en esta fábrica");
    }
}
