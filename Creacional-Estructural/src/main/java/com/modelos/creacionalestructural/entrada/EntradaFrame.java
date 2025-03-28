package com.modelos.creacionalestructural.entrada;
import javax.swing.*;

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
    public String capturar(){
        int indiceComida = eleccionComida();

        return foodOptions[indiceComida];
    }

    public int eleccionComida(){
        JComboBox<String> foodComboBox = new JComboBox<>(foodOptions);

        JPanel panel = new JPanel();
        panel.add(foodComboBox);

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
