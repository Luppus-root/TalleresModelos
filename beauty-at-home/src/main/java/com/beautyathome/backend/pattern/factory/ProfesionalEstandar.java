package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.builder.ServicioBuilder;

public class ProfesionalEstandar extends Profesional {

    public ProfesionalEstandar() {
        super();
    }

    public ProfesionalEstandar(ServicioBuilder servicioBuilder) {
        super(servicioBuilder);
    }

    public Profesional crearProfesional() {
        return new ProfesionalEstandar();
    }

}

