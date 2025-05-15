package mineria;

import java.io.*;

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
        analizarDatos(datos);
        enviarReporte(datos);
        cerrarArchivo(archivo);
    }

    protected abstract void abrirArchivo(String ruta);
    protected abstract void extraerDatos(File archivo);
    protected abstract void parsearDatos(File datosRaw);
    protected abstract void cerrarArchivo(File archivo);

    protected void analizarDatos(File datos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(datos))) {
            String linea;
            int contador = 0;
            while ((linea = reader.readLine()) != null) {
                contador += linea.split("\\s+").length;
            }
            System.out.println("Total palabras analizadas: " + contador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void enviarReporte(File analisis) {
        reporte = new File("reporte_final.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {
            writer.write("Reporte generado desde archivo: " + analisis.getName());
            writer.newLine();
            writer.write("Este es un reporte simulado.");
            System.out.println("Reporte guardado: " + reporte.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
