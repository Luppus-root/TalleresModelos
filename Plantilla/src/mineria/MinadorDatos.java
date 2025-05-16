package mineria;

import java.io.*;
import java.util.ArrayList;

public abstract class MinadorDatos {
    protected String ruta;
    protected File archivo;
    protected File datosRaw;
    protected File datos;
    protected File reporte;

    public final void minar(String ruta) {
        this.ruta = ruta;
        abrirArchivo(ruta);
        extraerDatos(archivo);
        parsearDatos(datosRaw);
        String[] palabras = analizarDatos(datos);
        enviarReporte(datos, palabras);
        cerrarArchivo(archivo);
    }
    protected abstract void abrirArchivo(String ruta);
    protected abstract void extraerDatos(File archivo);
    protected abstract void parsearDatos(File datosRaw);
    protected abstract void cerrarArchivo(File archivo);

    protected String[] analizarDatos(File datos) {
        ArrayList<String> palabrasEncontradas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(datos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.trim().split("\\s+");
                for (String p : palabras) {
                    if (!p.isBlank()) {
                        palabrasEncontradas.add(p);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabrasEncontradas.toArray(new String[0]);
    }

    protected void enviarReporte(File analisis, String[] palabras) {
        reporte = new File("reporte_final.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte));
             BufferedReader reader = new BufferedReader(new FileReader(analisis))) {

            writer.write("Reporte generado desde archivo: " + ruta);
            writer.newLine();
            writer.write("Palabras encontradas:" + palabras.length);
            writer.newLine();

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write("- " + linea);
                writer.newLine();
            }

            System.out.println("Reporte guardado: " + reporte.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(reporte);
            } else {
                System.out.println("No se puede abrir el archivo automáticamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el reporte: " + e.getMessage());
        }
    }
    }

