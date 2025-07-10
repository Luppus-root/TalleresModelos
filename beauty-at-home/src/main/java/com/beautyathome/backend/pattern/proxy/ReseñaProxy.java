package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.pattern.visitor.VisitorReseña;

public class ReseñaProxy implements Reseña {

    private ReseñaReal reseñaReal;

    // Simulación de permiso (en la práctica se debe pasar el usuario actual)
    private boolean accesoPermitido;

    public ReseñaProxy(ReseñaReal r) {
        this.reseñaReal = r;
        this.accesoPermitido = validarAcceso();
    }

    // Aquí podrías validar según el usuario autenticado, roles, etc.
    public boolean validarAcceso() {
        // Simulación: el cliente puede ver su propia reseña
        // return AuthService.usuarioActual().equals(reseñaReal.getCliente());
        return true; // por ahora damos acceso
    }

    @Override
    public void eliminarReseña() {
        if (accesoPermitido) {
            reseñaReal.eliminarReseña();
        } else {
            System.out.println("Acceso denegado para eliminar reseña.");
        }
    }

    @Override
    public String obtenerReseña() {
        if (accesoPermitido) {
            return reseñaReal.obtenerReseña();
        } else {
            return "No tienes permiso para ver esta reseña.";
        }
    }

    @Override
    public void aceptar(VisitorReseña v) {
        if (accesoPermitido) {
            reseñaReal.aceptar(v);
        } else {
            System.out.println("No autorizado para aplicar Visitor sobre esta reseña.");
        }
    }
}
