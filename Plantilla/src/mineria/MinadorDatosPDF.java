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
        datosRaw = new File("datos_raw_pdf.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datosRaw))) {
            writer.write("Contenido simulado extraído de PDF\nLinea dos\nLinea tres");
            System.out.println("Datos extraídos de PDF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void parsearDatos(File datosRaw) {
        datos = new File("datos_parseados_pdf.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(datosRaw));
             BufferedWriter writer = new BufferedWriter(new FileWriter(datos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea.toUpperCase());
                writer.newLine();
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
