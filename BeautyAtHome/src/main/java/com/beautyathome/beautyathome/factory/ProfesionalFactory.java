package com.beautyathome.beautyathome.factory;

import com.beautyathome.beautyathome.model.Profesional;


public interface ProfesionalFactory {
    Profesional crearProfesional(String nombre, String experiencia);
}
