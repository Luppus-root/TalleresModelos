package com.beautyathome.beautyathome.factory;

import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.model.ProfesionalEstandar;

// factory/FactoryProfesionalEstandar.java
public class FactoryProfesionalEstandar implements ProfesionalFactory {
    @Override
    public Profesional crearProfesional(String nombre, String experiencia) {
        return new ProfesionalEstandar(nombre, experiencia);
    }
}
