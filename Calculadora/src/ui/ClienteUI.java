// File: ui/ClienteUI.java
package ui;

import core.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ClienteUI extends JFrame {
    private final Cliente cliente;
    private final JTextField input;
    private final JLabel resultado;
    private final JLabel error;

    public ClienteUI() {
        cliente = new Cliente();
        setTitle("Calculadora con Deshacer/Rehacer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        input = new JTextField(20);
        input.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Ingrese el valor:"));
        inputPanel.add(input);

        resultado = new JLabel("Resultado: 0.0", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 18));
        resultado.setBorder(BorderFactory.createEtchedBorder());

        error = new JLabel();
        error.setForeground(Color.RED);
        error.setFont(new Font("Arial", Font.ITALIC, 12));

        JPanel buttons = new JPanel(new GridLayout(2, 4));
        buttons.add(createButton("+", () -> cliente.botonSumar(getValor()), KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0)));
        buttons.add(createButton("-", () -> cliente.botonRestar(getValor()), KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0)));
        buttons.add(createButton("*", () -> cliente.botonMultiplicar(getValor()), KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0)));
        buttons.add(createButton("/", () -> {
            float val = getValor();
            if (val == 0) {
                mostrarError("Error: División por cero");
            } else {
                cliente.botonDividir(val);
                actualizarResultado();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0)));
        buttons.add(createButton("C", () -> cliente.botonBorrar(), KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK)));
        buttons.add(createButton("Undo", cliente::botonDeshacer, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK)));
        buttons.add(createButton("Redo", cliente::botonRehacer, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK)));

        JButton actualizar = new JButton("Actualizar Resultado");
        actualizar.addActionListener(e -> actualizarResultado());

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(resultado, BorderLayout.CENTER);
        southPanel.add(error, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        add(actualizar, BorderLayout.EAST);

        setKeyBindings();
        setVisible(true);
    }

    private JButton createButton(String label, Runnable accion, KeyStroke keyStroke) {
        JButton b = new JButton(label);
        b.addActionListener(e -> {
            accion.run();
            actualizarResultado();
        });
        if (keyStroke != null) {
            b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, label);
            b.getActionMap().put(label, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accion.run();
                    actualizarResultado();
                }
            });
        }
        return b;
    }

    private float getValor() {
        try {
            error.setText("");
            return Float.parseFloat(input.getText());
        } catch (NumberFormatException e) {
            mostrarError("Error: Entrada inválida");
            return 0;
        }
    }

    private void mostrarError(String msg) {
        error.setText(msg);
    }

    private void actualizarResultado() {
        resultado.setText("Resultado: " + cliente.getResultado());
    }

    private void setKeyBindings() {
        input.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "actualizar");
        input.getActionMap().put("actualizar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarResultado();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Usar look and feel por defecto
            }
            new ClienteUI();
        });
    }
}
