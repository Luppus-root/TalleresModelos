package com.modelos.creacionalestructural.cliente;

import com.modelos.creacionalestructural.Factory.EntradaSalidaFabricaAbstracta;
import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.salida.Salida;

public class Cliente {
    private final Entrada entrada;
    private final Salida salida;

    public Cliente(EntradaSalidaFabricaAbstracta factory) {
        this.entrada = factory.crearEntrada();
        this.salida = factory.crearSalida();
    }

    public void mostrarDatos(String mensaje) {
        salida.mostrar(mensaje);
    }

    public String capturarDatos() {
        return entrada.capturar();
    }
}