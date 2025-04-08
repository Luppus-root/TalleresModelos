package ui;

import javax.swing.*;
import java.awt.*;

import builder.*;
import model.pizzas.*;
import model.base.PizzaClonable;

public class GraphicalUI {
    private static JTextArea outputArea;
    private static Chef chefHawaiana;
    private static Chef chefPollo;
    private static Cliente cliente;
    private static PizzaHawaiana pizzaHawaiana;
    private static PizzaPollo pizzaPollo;
    private static PizzaClonable pizzaHawaianaClon;
    private static PizzaClonable pizzaPolloClon;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        chefHawaiana = new ChefPizzaHawaiana();
        chefPollo = new ChefPizzaPollo();
        cliente = new Cliente(chefHawaiana);

        JFrame frame = new JFrame("Aplicación de Pizzas - Interfaz Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(250, 250, 255));

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 12, 12));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        buttonPanel.setBackground(new Color(250, 250, 255));

        JButton crearHawaianaBtn = new JButton("Crear Pizza Hawaiana");
        JButton crearPolloBtn = new JButton("Crear Pizza de Pollo");
        JButton clonarHawaianaBtn = new JButton("Clonar Pizza Hawaiana");
        JButton clonarPolloBtn = new JButton("Clonar Pizza de Pollo");
        JButton compararBtn = new JButton("Comparar Instancias");
        JButton limpiarBtn = new JButton("Limpiar Salida");

        Dimension buttonSize = new Dimension(180, 40);
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 15);

        for (JButton button : new JButton[]{crearHawaianaBtn, crearPolloBtn, clonarHawaianaBtn, clonarPolloBtn, compararBtn, limpiarBtn}) {
            button.setPreferredSize(buttonSize);
            button.setBackground(new Color(220, 230, 241));
            button.setForeground(new Color(40, 40, 40));
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 200)));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttonPanel.add(button);
        }

        // Área de texto para mostrar resultados
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBackground(new Color(245, 245, 250));
        outputArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Salida"));

        crearHawaianaBtn.addActionListener(e -> crearPizzaHawaiana());
        crearPolloBtn.addActionListener(e -> crearPizzaPollo());
        clonarHawaianaBtn.addActionListener(e -> clonarPizzaHawaiana());
        clonarPolloBtn.addActionListener(e -> clonarPizzaPollo());
        compararBtn.addActionListener(e -> compararInstancias());
        limpiarBtn.addActionListener(e -> outputArea.setText(""));

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        appendToOutput("\uD83C\uDF55 Bienvenido a la Aplicación de Pizzas (Interfaz Gráfica)\n");
        appendToOutput("Utilice los botones para crear y clonar pizzas.\n");
    }

    private static void crearPizzaHawaiana() {
        appendToOutput("\n----- Creando una Pizza Hawaiana original -----\n");
        cliente.setChef(chefHawaiana);
        pizzaHawaiana = (PizzaHawaiana) cliente.construirPizzaHawaiana(
                "integral", 5.0,
                "mozzarella", 3.0,
                "dulce", 2.5,
                "cherry", 1.8,
                2.0
        );
        appendToOutput(pizzaHawaiana.getDescripcion());
    }

    private static void crearPizzaPollo() {
        appendToOutput("\n----- Creando una Pizza de Pollo original -----\n");
        cliente.setChef(chefPollo);
        pizzaPollo = (PizzaPollo) cliente.construirPizzaPollo(
                "normal", 4.0,
                "cheddar", 3.5,
                "desmenuzado", 4.5,
                "italiano", 2.0,
                1.5
        );
        appendToOutput(pizzaPollo.getDescripcion());
    }

    private static void clonarPizzaHawaiana() {
        if (pizzaHawaiana == null) {
            appendToOutput("\nError: Primero debe crear una Pizza Hawaiana original.\n");
            return;
        }

        appendToOutput("\n----- Clonando la Pizza Hawaiana -----\n");
        pizzaHawaianaClon = pizzaHawaiana.clonar();
        appendToOutput(((PizzaHawaiana) pizzaHawaianaClon).getDescripcion());
    }

    private static void clonarPizzaPollo() {
        if (pizzaPollo == null) {
            appendToOutput("\nError: Primero debe crear una Pizza de Pollo original.\n");
            return;
        }

        appendToOutput("\n----- Clonando la Pizza de Pollo -----\n");
        pizzaPolloClon = pizzaPollo.clonar();
        appendToOutput(((PizzaPollo) pizzaPolloClon).getDescripcion());
    }

    private static void compararInstancias() {
        if (pizzaHawaiana == null || pizzaHawaianaClon == null) {
            appendToOutput("\nError: Primero debe crear y clonar una Pizza Hawaiana.\n");
            return;
        }

        appendToOutput("\n----- Comparando instancias de Pizza Hawaiana -----\n");
        appendToOutput("Son la misma instancia? " + (pizzaHawaiana == pizzaHawaianaClon));
        appendToOutput("Tienen la misma descripción? " +
                pizzaHawaiana.getDescripcion().equals(
                        ((PizzaHawaiana) pizzaHawaianaClon).getDescripcion()));
    }

    private static void appendToOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
}
