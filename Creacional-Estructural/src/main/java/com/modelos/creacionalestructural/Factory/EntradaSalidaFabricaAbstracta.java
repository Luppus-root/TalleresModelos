package com.modelos.creacionalestructural.Factory;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.entrada.EntradaFrame;
import com.modelos.creacionalestructural.salida.Salida;
import com.modelos.creacionalestructural.salida.SalidaFrame;


public interface EntradaSalidaFabricaAbstracta{

    public Entrada crearEntrada();
    public Salida crearSalida();


}
