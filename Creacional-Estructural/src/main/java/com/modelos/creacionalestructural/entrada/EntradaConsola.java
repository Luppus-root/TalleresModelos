package com.modelos.creacionalestructural.entrada;

import com.modelos.creacionalestructural.adapters.AdapterStringInt;
import com.modelos.creacionalestructural.adapters.InterfaceStringInt;

import java.util.Scanner;

public class EntradaConsola extends Entrada {

    protected final Scanner scanner = new Scanner(System.in);
    private final AdapterStringInt adaptador = new AdapterStringInt();
    @Override
    public String capturar() {
        System.out.println("Seleccione la comida: ");
        System.out.println("(1). Hamburguesa & Coca Cola");
        System.out.println("(2). Hamburguesa & Agua");
        System.out.println("(3). Pizza & Coca Cola");
        System.out.println("(4). Pizza & Agua");
        System.out.println("(5). Ensalada & Coca Cola");
        System.out.println("(6). Ensalada & Agua");
        System.out.println("Seleccione: ");
        String seleccion = scanner.nextLine();

        String[] opciones = {
                "Hamburguesa & Coca Cola",
                "Hamburguesa & Agua",
                "Pizza & Coca Cola",
                "Pizza & Agua",
                "Ensalada & Coca Cola",
                "Ensalada & Agua"
        };

        return opciones[adaptador.convertir(seleccion)-1];
    }
}
