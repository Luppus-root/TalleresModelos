package com.beautyathome.backend.pattern.visitor;

import com.beautyathome.backend.pattern.proxy.ReseñaReal;
import com.beautyathome.backend.entity.Cliente;

import java.time.format.DateTimeFormatter;

public class ExportarVisitor implements VisitorReseña {

    private final String formato;

    public ExportarVisitor(String formato) {
        this.formato = formato.toLowerCase();
    }

    @Override
    public void visitReseñaReal(ReseñaReal r) {
        switch (formato) {
            case "json" -> exportarComoJSON(r);
            case "csv" -> exportarComoCSV(r);
            default -> System.out.println("Formato no soportado: " + formato);
        }
    }

    private void exportarComoJSON(ReseñaReal r) {
        Cliente cliente = r.getCliente();
        String nombreCliente = (cliente != null && cliente.getNombre() != null) ? cliente.getNombre() : "Anónimo";
        String comentario = r.getComentario() != null ? r.getComentario() : "";
        String fecha = r.getFechaRealizacion() != null
                ? r.getFechaRealizacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : "Sin fecha";

        String json = String.format("""
        {
          "cliente": "%s",
          "calificacion": %d,
          "comentario": "%s",
          "fecha": "%s"
        }
        """, nombreCliente, r.getCalificacion(), comentario, fecha);

        System.out.println("📤 Exportación JSON:\n" + json);
    }

    private void exportarComoCSV(ReseñaReal r) {
        Cliente cliente = r.getCliente();
        String nombreCliente = (cliente != null && cliente.getNombre() != null) ? cliente.getNombre() : "Anónimo";
        String comentario = r.getComentario() != null ? r.getComentario() : "";
        String fecha = r.getFechaRealizacion() != null
                ? r.getFechaRealizacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : "Sin fecha";

        String csv = String.format("\"%s\",%d,\"%s\",\"%s\"",
                nombreCliente,
                r.getCalificacion(),
                comentario,
                fecha);

        System.out.println("📤 Exportación CSV:\n" + csv);
    }
}
