package com.modelos.creacionalestructural.salida;
import javax.swing.JOptionPane;


public class SalidaFrame extends Salida {

        @Override
        public void mostrar(String m) {

        JOptionPane.showMessageDialog(null, "Combo seleccionado: " + m);

    }

}
