package com.modelos.creacionalestructural.Factory;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.entrada.EntradaConsola;
import com.modelos.creacionalestructural.salida.Salida;
import com.modelos.creacionalestructural.salida.SalidaConsola;

public class FabricaEntradaSalidaConsola implements EntradaSalidaFabricaAbstracta{
    @Override
    public Entrada crearEntrada() {
        return new EntradaConsola();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaConsola();
    }
}
