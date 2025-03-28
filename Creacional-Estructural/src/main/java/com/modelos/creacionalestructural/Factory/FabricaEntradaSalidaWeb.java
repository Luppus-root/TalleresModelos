package com.modelos.creacionalestructural.Factory;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.entrada.EntradaWeb;
import com.modelos.creacionalestructural.salida.Salida;
import com.modelos.creacionalestructural.salida.SalidaWeb;

public class FabricaEntradaSalidaWeb implements EntradaSalidaFabricaAbstracta {

    public Entrada crearEntrada() {
        return new EntradaWeb();
    }

    public Salida crearSalida() {
        return new SalidaWeb();
    }
}
