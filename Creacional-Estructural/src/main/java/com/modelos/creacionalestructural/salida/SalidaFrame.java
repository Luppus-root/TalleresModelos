package com.modelos.creacionalestructural.salida;

import javax.swing.*;
import java.awt.*;

public class SalidaFrame extends Salida {

    @Override
    public void mostrar(String m) {
        // Personalizar la fuente y el color del mensaje
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("OptionPane.messageForeground", new Color(0, 70, 150)); // Azul oscuro

        // Personalizar el fondo del JOptionPane
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        // Crear un panel con un diseño mejorado
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        panel.add(new JLabel("Combo seleccionado:"));
        panel.add(new JLabel(m));
        panel.add(Box.createVerticalGlue());

        // Mostrar el JOptionPane con el panel personalizado
        JOptionPane.showMessageDialog(null, panel, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}