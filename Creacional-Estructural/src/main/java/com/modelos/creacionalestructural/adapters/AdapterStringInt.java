package com.modelos.creacionalestructural.adapters;

import com.modelos.creacionalestructural.entrada.Entrada;
import com.modelos.creacionalestructural.entrada.EntradaConsola;

import javax.swing.*;
import java.util.Scanner;

public class AdapterStringInt implements InterfaceStringInt {

    @Override
    public int convertir(String input) {
        return Integer.parseInt(input);


    }

}