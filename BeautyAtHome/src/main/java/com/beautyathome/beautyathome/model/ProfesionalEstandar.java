package com.beautyathome.beautyathome.model;

// model/ProfesionalEstandar.java
public class ProfesionalEstandar extends Profesional {
    public ProfesionalEstandar(String nombre, String experiencia) {
        super(nombre, experiencia);
    }

    @Override
    public boolean usaProductosExclusivos() {
        return false;
    }

    @Override
    public String tipo() {
        return "Estandar";
    }
}
