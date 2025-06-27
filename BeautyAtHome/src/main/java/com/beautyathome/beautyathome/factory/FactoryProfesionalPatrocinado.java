package com.beautyathome.beautyathome.factory;

import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.model.ProfesionalPatrocinado;

public class FactoryProfesionalPatrocinado implements ProfesionalFactory {
    private final String marca;

    public FactoryProfesionalPatrocinado(String marca) {
        this.marca = marca;
    }

    @Override
    public Profesional crearProfesional(String nombre, String experiencia) {
        return new ProfesionalPatrocinado(nombre, experiencia, marca);
    }
}
