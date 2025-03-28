package com.modelos.creacionalestructural.salida;

public class SalidaConsola extends Salida{

    @Override
    public void mostrar(String mensaje) {
        System.out.println("Combo Seleccionado: " + mensaje);
    }
}
