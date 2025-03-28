package com.modelos.creacionalestructural.factory;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.salida.Salida;

public interface EntradaSalidaFabricaAbstracta {

    public Entrada crearEntrada();
    public Salida crearSalida();

}
