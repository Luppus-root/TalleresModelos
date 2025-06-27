package com.beautyathome.beautyathome.service.chain;

import com.beautyathome.beautyathome.service.dto.AgendamientoSolicitud;

// service/chain/ManejadorAgendamiento.java
public interface ManejadorAgendamiento {
    void establecerSiguiente(ManejadorAgendamiento siguiente);
    boolean manejar(AgendamientoSolicitud solicitud);
}
