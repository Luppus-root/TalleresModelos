package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.entity.ProfesionalEstandar;
import com.beautyathome.backend.entity.ProfesionalPatrocinado;
import org.springframework.stereotype.Component;

@Component
public class ProfesionalPatrocinadoFactory implements ProfesionalFactory {

    @Override
    public ProfesionalEstandar crearProfesionalEstandar() {
        throw new UnsupportedOperationException("No soportado en esta fábrica");
    }

    @Override
    public ProfesionalPatrocinado crearProfesionalPatrocinado() {
        return new ProfesionalPatrocinado();
    }
}
