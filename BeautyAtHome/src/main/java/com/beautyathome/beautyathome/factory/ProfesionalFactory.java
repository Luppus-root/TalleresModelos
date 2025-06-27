package com.beautyathome.beautyathome.factory;

import com.beautyathome.beautyathome.model.Profesional;

// factory/ProfesionalFactory.java
public interface ProfesionalFactory {
    Profesional crearProfesional(String nombre, String experiencia);
}
