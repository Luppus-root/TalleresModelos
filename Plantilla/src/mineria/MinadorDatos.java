package mineria;

import java.awt.*;
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
                String[] palabrasLinea = linea.trim().split("\\s+");
                for (String palabra : palabrasLinea) {
                    if (!palabra.isBlank()) {
                        palabrasEncontradas.add(palabra);
                    }
                }
            }
            System.out.println("Total palabras analizadas: " + palabrasEncontradas.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabrasEncontradas.toArray(new String[0]);
    }

    protected void enviarReporte(File analisis, String[] palabras) {
        reporte = new File("reporte_final.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {
            writer.write("Reporte generado desde archivo: " + analisis.getName());
            writer.newLine();
            writer.write("Total de palabras encontradas: " + palabras.length);
            writer.newLine();
            writer.newLine();
            for (String palabra : palabras) {
                writer.write(palabra);
                writer.newLine();
            }
            System.out.println("Reporte guardado: " + reporte.getAbsolutePath());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(reporte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
