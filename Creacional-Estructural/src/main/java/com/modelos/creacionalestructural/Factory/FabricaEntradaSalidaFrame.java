package com.modelos.creacionalestructural.Factory;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.salida.Salida;

public interface FabricaEntradaSalidaFrame {

    public Entrada crear_entrada();
    public Salida crear_salida();


}
