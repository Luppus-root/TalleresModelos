package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import model.base.Comida;
import model.ingredientes.*;
import model.pizzas.*;

public class GraphicalUI {

    private static JTextArea outputArea;
    private static JComboBox<String> tipoPizzaCombo;
    private static List<JCheckBox> checkBoxesIngredientes = new ArrayList<>();
    private static final Comida[] INGREDIENTES = {
            new Masa("Integral", 5.0),
            new Masa("Normal", 4.0),
            new Queso("Mozzarella", 3.0),
            new Queso("Cheddar", 3.5),
            new SalsaTomate(new Tomate("Dulce", 1.5), 2.5),
            new SalsaTomate(new Tomate("Italiana", 1.8), 2.0),
            new Piña("Cherry", 1.8),
            new Tomate("Fresco", 1.5),
            new Pollo("Desmenuzado", 4.5)
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicalUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("🍕 Creador de Pizzas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(255, 245, 235)); // Color de fondo suave

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(BorderFactory.createTitledBorder("Tipo de pizza"));
        topPanel.setBackground(new Color(255, 245, 235));
        tipoPizzaCombo = new JComboBox<>(new String[]{"Hawaiana", "Pollo"});
        tipoPizzaCombo.setPreferredSize(new Dimension(200, 30));
        topPanel.add(tipoPizzaCombo);

        JPanel ingredientesPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // Espacio entre componentes
        ingredientesPanel.setBorder(BorderFactory.createTitledBorder("Ingredientes"));
        ingredientesPanel.setBackground(new Color(255, 245, 235));
        ingredientesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno
        for (Comida ing : INGREDIENTES) {
            JCheckBox box = new JCheckBox(ing.getDescripcion());
            box.setBackground(new Color(255, 245, 235));
            checkBoxesIngredientes.add(box);
            ingredientesPanel.add(box);
        }

        JButton calcularBtn = new JButton("Calcular Total");
        calcularBtn.setBackground(new Color(255, 220, 180)); // Color de botón
        calcularBtn.setForeground(Color.BLACK);
        calcularBtn.setPreferredSize(new Dimension(150, 40));
        calcularBtn.addActionListener(GraphicalUI::calcularCuenta);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resumen"));
        scrollPane.setPreferredSize(new Dimension(300, 0)); // Ancho fijo para el resumen

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(ingredientesPanel, BorderLayout.CENTER);
        frame.add(calcularBtn, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private static void calcularCuenta(ActionEvent e) {
        String tipoPizza = (String) tipoPizzaCombo.getSelectedItem();
        double total = 0.0;
        StringBuilder desc = new StringBuilder();

        Pizza pizza;

        if ("Hawaiana".equals(tipoPizza)) {
            pizza = new PizzaHawaiana();
        } else {
            pizza = new PizzaPollo();
        }

        desc.append("\n🍕 Pizza: ").append(tipoPizza).append("\nIngredientes seleccionados:\n");

        for (int i = 0; i < checkBoxesIngredientes.size(); i++) {
            JCheckBox cb = checkBoxesIngredientes.get(i);
            if (cb.isSelected()) {
                Comida ing = INGREDIENTES[i];
                desc.append(" - ").append(ing.getDescripcion()).append("\n");
                total += ing.getPrecioUnitario();

                if (pizza instanceof PizzaHawaiana) {
                    PizzaHawaiana p = (PizzaHawaiana) pizza;
                    if (ing instanceof Masa) p.setMasa((Masa) ing);
                    else if (ing instanceof Queso) p.setQueso((Queso) ing);
                    else if (ing instanceof Tomate) p.setTomate((Tomate) ing);
                    else if (ing instanceof SalsaTomate) p.setSalsaTomate((SalsaTomate) ing);
                    else if (ing instanceof Piña) p.setPiña((Piña) ing);
                } else if (pizza instanceof PizzaPollo) {
                    PizzaPollo p = (PizzaPollo) pizza;
                    if (ing instanceof Masa) p.setMasa((Masa) ing);
                    else if (ing instanceof Queso) p.setQueso((Queso) ing);
                    else if (ing instanceof Tomate) p.setTomate((Tomate) ing);
                    else if (ing instanceof SalsaTomate) p.setSalsaTomate((SalsaTomate) ing);
                    else if (ing instanceof Pollo) p.setPollo((Pollo) ing);
                }
            }
        }

        desc.append("\n🧾 Descripción pizza:\n").append(pizza.getDescripcion());
        desc.append("\n\n💰 Total a pagar: $").append(String.format("%.2f", total));
        outputArea.setText(desc.toString());
    }
}