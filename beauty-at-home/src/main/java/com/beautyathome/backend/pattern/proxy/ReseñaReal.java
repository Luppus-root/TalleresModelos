package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.entity.Cliente;
import com.beautyathome.backend.pattern.visitor.VisitorReseña;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Date;

public class ReseñaReal implements Reseña {

    private Cliente cliente;
    private int calificacion;
    private String comentario;
    private Date fechaRealizacion;
    private BufferedImage[] fotosResultado;

    public ReseñaReal(Cliente cliente, int calificacion, String comentario, Date fechaRealizacion, BufferedImage[] fotosResultado) {
        this.cliente = cliente;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaRealizacion = fechaRealizacion;
        this.fotosResultado = fotosResultado;
    }

    @Override
    public void eliminarReseña() {
        this.comentario = "[ELIMINADA]";
        this.calificacion = 0;
        this.fotosResultado = new BufferedImage[0];
        System.out.println("Reseña eliminada.");
    }

    @Override
    public String obtenerReseña() {
        return "Cliente: " + cliente.getNombre() + "\n"
                + "Calificación: " + calificacion + "\n"
                + "Comentario: " + comentario + "\n"
                + "Fecha: " + fechaRealizacion + "\n"
                + "Fotos: " + (fotosResultado != null ? fotosResultado.length : 0);
    }

    @Override
    public void aceptar(VisitorReseña v) {
        v.visitReseñaReal(this);
    }

    // Getters para Visitor u otras lógicas si se necesita acceso seguro
    public Cliente getCliente() {
        return cliente;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public BufferedImage[] getFotosResultado() {
        return fotosResultado;
    }
}
