package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.entity.Reseña;
import com.beautyathome.backend.entity.Cliente;
import com.beautyathome.backend.pattern.visitor.VisitorReseña;

import java.time.LocalDate;

public class ReseñaReal implements IReseña {

    private Reseña reseña;

    public ReseñaReal(Reseña reseña) {
        this.reseña = reseña;
    }

    @Override
    public void eliminarReseña() {
        reseña.setTexto("[RESEÑA ELIMINADA]");
        reseña.setEstrellas(0);
        System.out.println("Reseña eliminada.");
    }

    @Override
    public String obtenerReseña() {
        return "Cliente: " + getCliente().getNombre() + "\n"
                + "Estrellas: " + getCalificacion() + "\n"
                + "Comentario: " + getComentario() + "\n"
                + "Fecha: " + getFechaRealizacion();
    }

    @Override
    public void exportar() {
        System.out.println("Exportando reseña...");
    }

    @Override
    public String resumen() {
        String texto = getComentario();
        return texto.substring(0, Math.min(texto.length(), 50)) + "...";
    }

    @Override
    public void aceptar(VisitorReseña v) {
        v.visitReseñaReal(this);
    }

    public Cliente getCliente() {
        if (reseña.getServicioRealizado() != null) {
            return reseña.getServicioRealizado().getCliente();
        }
        return null;
    }

    public LocalDate getFechaRealizacion() {
        if (reseña.getServicioRealizado() != null) {
            return reseña.getServicioRealizado().getFecha();
        }
        return null;
    }


    public int getCalificacion() {
        return reseña.getEstrellas();
    }

    public String getComentario() {
        return reseña.getTexto();
    }

    public Reseña getReseña() {
        return reseña;
    }
}
