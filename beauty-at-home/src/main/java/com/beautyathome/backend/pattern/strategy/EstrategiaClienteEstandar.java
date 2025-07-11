package com.beautyathome.backend.pattern.strategy;

public class EstrategiaClienteEstandar implements IEstrategia {

    @Override
    public String generarInterfaz (String nombreCliente) {
        return "¡Hola " + nombreCliente + "! Gracias por ser nuestro cliente estándar.";
    }
}

