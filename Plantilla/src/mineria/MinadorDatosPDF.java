package mineria;

import java.io.*;

public class MinadorDatosPDF extends MinadorDatos {

    @Override
    protected void abrirArchivo(String ruta) {
        archivo = new File(ruta);
        System.out.println("Abriendo archivo PDF: " + archivo.getName());
    }


    @Override
    protected void extraerDatos(File archivo) {
        datosRaw = new File("datos_raw.pdf");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter(datosRaw))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Datos extraídos del archivo real.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void parsearDatos(File datosRaw) {
        datos = new File("datos_parseados.pdf");
        String palabraClave = "PDF";

        try (BufferedReader reader = new BufferedReader(new FileReader(datosRaw));
             BufferedWriter writer = new BufferedWriter(new FileWriter(datos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String lineaProcesada = linea.toLowerCase();
                String[] palabras = linea.replace(",", " ").split("\\s+");
                for (String palabra : palabras) {
                    if (palabra.toLowerCase().contains(palabraClave)) {
                        writer.write(palabra);
                        writer.newLine();
                    }
                }

            }
            System.out.println("Datos parseados de PDF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void cerrarArchivo(File archivo) {
        System.out.println("Archivo PDF cerrado.");
    }
}
