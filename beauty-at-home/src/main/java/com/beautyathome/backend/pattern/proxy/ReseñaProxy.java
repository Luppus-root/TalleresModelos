package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.entity.Reseña;
import com.beautyathome.backend.repository.ReseñaRepository;
import com.beautyathome.backend.pattern.visitor.VisitorReseña;

public class ReseñaProxy implements IReseña {

    private Long idReseña;
    private ReseñaReal reseñaReal;
    private ReseñaRepository reseñaRepository;

    public ReseñaProxy(Long idReseña, ReseñaRepository reseñaRepository) {
        this.idReseña = idReseña;
        this.reseñaRepository = reseñaRepository;
    }

    private void cargarReseña() {
        if (reseñaReal == null) {
            Reseña entity = reseñaRepository.findById(idReseña)
                    .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
            this.reseñaReal = new ReseñaReal(entity);
        }
    }

    @Override
    public void eliminarReseña() {
        cargarReseña();
        reseñaReal.eliminarReseña();
    }

    @Override
    public String obtenerReseña() {
        cargarReseña();
        return reseñaReal.obtenerReseña();
    }

    @Override
    public void exportar() {
        cargarReseña();
        reseñaReal.exportar();
    }

    @Override
    public String resumen() {
        cargarReseña();
        return reseñaReal.resumen();
    }

    @Override
    public void aceptar(VisitorReseña v) {
        cargarReseña();
        reseñaReal.aceptar(v);
    }
}
