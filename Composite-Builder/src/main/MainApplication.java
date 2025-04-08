package main;

import javax.swing.*;
import java.awt.*;
import ui.ConsoleUI;
import ui.GraphicalUI;

public class MainApplication {
    public static void main(String[] args) {
        // Crear y configurar el frame de selección
        JFrame selectionFrame = new JFrame("Aplicación de Pizzas");
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectionFrame.setSize(560, 280);
        selectionFrame.setLayout(new BorderLayout(10, 10));
        selectionFrame.getContentPane().setBackground(new Color(250, 250, 255));

        // Panel principal con mensaje
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(250, 250, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel titleLabel = new JLabel("\uD83C\uDF55 Bienvenido a la Aplicación de Pizzas");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 37, 41));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel("Seleccione la interfaz que desea utilizar:");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        messageLabel.setForeground(new Color(80, 80, 80));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        buttonPanel.setBackground(new Color(250, 250, 255));

        JButton consoleButton = new JButton("Consola");
        JButton graphicalButton = new JButton("Gráfica");

        // Estilo uniforme de botones
        Dimension buttonSize = new Dimension(160, 45);
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 15);

        for (JButton button : new JButton[]{consoleButton, graphicalButton}) {
            button.setPreferredSize(buttonSize);
            button.setBackground(new Color(220, 230, 241));
            button.setForeground(new Color(40, 40, 40));
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 200)));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        // Acciones de los botones
        consoleButton.addActionListener(e -> {
            selectionFrame.dispose();
            ConsoleUI.main(null);
        });

        graphicalButton.addActionListener(e -> {
            selectionFrame.dispose();
            GraphicalUI.main(null);
        });

        // Añadir componentes
        buttonPanel.add(consoleButton);
        buttonPanel.add(graphicalButton);

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(messageLabel);

        // Añadir paneles al frame
        selectionFrame.add(mainPanel, BorderLayout.CENTER);
        selectionFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Centrar y mostrar
        selectionFrame.setLocationRelativeTo(null);
        selectionFrame.setVisible(true);
    }
}