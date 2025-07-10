package com.beautyathome.backend.pattern.visitor;

import com.beautyathome.backend.pattern.proxy.ReseñaReal;

public class ExportarVisitor implements VisitorReseña {

    private String formato;

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
        String json = String.format("""
        {
          "cliente": "%s",
          "calificacion": %d,
          "comentario": "%s",
          "fecha": "%s"
        }
        """, r.getCliente().getNombre(), r.getCalificacion(), r.getComentario(), r.getFechaRealizacion());
        System.out.println(json);
    }

    private void exportarComoCSV(ReseñaReal r) {
        String csv = String.format("\"%s\",%d,\"%s\",\"%s\"",
                r.getCliente().getNombre(),
                r.getCalificacion(),
                r.getComentario(),
                r.getFechaRealizacion());
        System.out.println(csv);
    }
}
