package com.modelos.creacionalestructural.entrada;
import javax.swing.JOptionPane;

public class EntradaFrame extends Entrada {

    @Override
    public String capturar(){

        return JOptionPane.showInputDialog("");
    }

    public EntradaFrame() {

    };

}
