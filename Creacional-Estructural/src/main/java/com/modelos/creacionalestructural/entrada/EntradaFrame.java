package com.modelos.creacionalestructural.entrada;

import javax.swing.*;
import java.awt.*;

public class EntradaFrame extends Entrada {

    String[] foodOptions = {
            "Hamburguesa & Coca Cola",
            "Hamburguesa & Agua",
            "Pizza & Coca Cola",
            "Pizza & Agua",
            "Ensalada & Coca Cola",
            "Ensalada & Agua"
    };

    @Override
    public String capturar() {
        int indiceComida = eleccionComida();

        return foodOptions[indiceComida];
    }

    public int eleccionComida() {
        JComboBox<String> foodComboBox = new JComboBox<>(foodOptions);
        foodComboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Mejora la fuente

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Mejora el diseño
        panel.add(Box.createVerticalGlue()); // Centra verticalmente
        panel.add(foodComboBox);
        panel.add(Box.createVerticalGlue()); // Centra verticalmente

        // Mejora el diálogo
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Seleccione su Combo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            return foodComboBox.getSelectedIndex();
        } else {
            return -1;
        }
    }
}