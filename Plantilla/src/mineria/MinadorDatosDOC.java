package mineria;

import java.io.*;

public class MinadorDatosDOC extends MinadorDatos {

    @Override
    protected void abrirArchivo(String ruta) {
        archivo = new File(ruta);
        System.out.println("Abriendo archivo DOC: " + archivo.getName());
    }

    @Override
    protected void extraerDatos(File archivo) {
        datosRaw = new File("datos_raw_doc.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datosRaw))) {
            writer.write("Este es un contenido de prueba para DOC\nCon varias lineas\nFin del DOC");
            System.out.println("Datos extraídos de DOC");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void parsearDatos(File datosRaw) {
        datos = new File("datos_parseados_doc.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(datosRaw));
             BufferedWriter writer = new BufferedWriter(new FileWriter(datos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea.toLowerCase());
                writer.newLine();
            }
            System.out.println("Datos parseados de DOC");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void cerrarArchivo(File archivo) {
        System.out.println("Archivo DOC cerrado.");
    }
}