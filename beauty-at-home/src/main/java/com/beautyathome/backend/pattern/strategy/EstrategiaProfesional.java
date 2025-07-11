
package com.beautyathome.backend.pattern.strategy;


public class EstrategiaProfesional implements IEstrategia {

    @Override
    public String generarInterfaz(String nombreProfesional) {

        return "Bienvenido profesional: " + nombreProfesional + ". Aquí está tu panel de gestión de servicios.";
    }
}