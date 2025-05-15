import mineria.MinadorDatos;
import mineria.MinadorDatosCSV;
import mineria.MinadorDatosDOC;
import mineria.MinadorDatosPDF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Minador de Datos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 350);
            frame.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel rutaLabel = new JLabel("Ruta del archivo:");
            JTextField rutaField = new JTextField();
            JButton explorarBtn = new JButton("Explorar...");

            JLabel tipoLabel = new JLabel("Tipo de archivo:");
            String[] tipos = {"DOC", "CSV", "PDF"};
            JComboBox<String> tipoCombo = new JComboBox<>(tipos);

            JButton ejecutarBtn = new JButton("Ejecutar Minado");
            JTextArea outputArea = new JTextArea(8, 40);
            outputArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(outputArea);

            gbc.gridx = 0;
            gbc.gridy = 0;
            frame.add(rutaLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            frame.add(rutaField, gbc);

            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            frame.add(explorarBtn, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            frame.add(tipoLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            frame.add(tipoCombo, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 3;
            frame.add(ejecutarBtn, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 3;
            frame.add(scrollPane, gbc);

            explorarBtn.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    rutaField.setText(selectedFile.getAbsolutePath());
                }
            });

            ejecutarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ruta = rutaField.getText();
                    String tipo = (String) tipoCombo.getSelectedItem();
                    MinadorDatos minador;

                    switch (tipo) {
                        case "DOC":
                            minador = new MinadorDatosDOC();
                            break;
                        case "CSV":
                            minador = new MinadorDatosCSV();
                            break;
                        case "PDF":
                            minador = new MinadorDatosPDF();
                            break;
                        default:
                            outputArea.setText("Tipo no soportado");
                            return;
                    }

                    try {
                        minador.minar(ruta);
                        outputArea.setText("Minado exitoso. Verifica los archivos generados.");
                    } catch (Exception ex) {
                        outputArea.setText("Error al minar: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}