package mineria;

import java.io.*;

public class    MinadorDatosCSV extends MinadorDatos {

    @Override
    protected void abrirArchivo(String ruta) {
        archivo = new File(ruta);
        System.out.println("Abriendo archivo CSV: " + archivo.getName());
    }

    @Override
    protected void extraerDatos(File archivo) {
        datosRaw = archivo;
        System.out.println("Lectura directa de CSV");
    }

    @Override
    protected void parsearDatos(File datosRaw) {
        datos = new File("datos_parseados.txt");
        String palabraClave = "CSV";

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
            System.out.println("Datos parseados de CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void cerrarArchivo(File archivo) {
        System.out.println("Archivo CSV cerrado.");
    }
}
