package com.modelos.creacionalestructural.Factory;

import com.modelos.creacionalestructural.adapters.AdapterStringInt;
import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.entrada.EntradaFrame;
import com.modelos.creacionalestructural.salida.Salida;
import com.modelos.creacionalestructural.salida.SalidaFrame;

public class FabricaEntradaSalidaFrame implements EntradaSalidaFabricaAbstracta{

    public Entrada crearEntrada(){
        return new AdapterStringInt();
    }

    public Salida crearSalida(){
        return new SalidaFrame();
    }

    public FabricaEntradaSalidaFrame() {
    }


}
