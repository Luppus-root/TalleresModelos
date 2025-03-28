package com.modelos.creacionalestructural.entrada;

import com.modelos.creacionalestructural.entrada.Entrada;

import java.util.Scanner;

public class EntradaConsola extends Entrada {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String capturar() {
        return scanner.nextLine();
    }


}
