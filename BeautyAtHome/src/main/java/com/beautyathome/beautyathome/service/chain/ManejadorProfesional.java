package com.beautyathome.beautyathome.service.chain;

import com.beautyathome.beautyathome.agenda.Agenda;
import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.service.dto.AgendamientoSolicitud;
import lombok.RequiredArgsConstructor;

// service/chain/ManejadorProfesional.java
@RequiredArgsConstructor
public class ManejadorProfesional implements ManejadorAgendamiento {

    private final Profesional profesional;
    private final Agenda agenda;
    private ManejadorAgendamiento siguiente;

    @Override
    public void establecerSiguiente(ManejadorAgendamiento siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean manejar(AgendamientoSolicitud solicitud) {
        boolean cubreZona = profesional.getZonasCobertura().contains(solicitud.zona());
        boolean ofreceServicio = profesional.getServicios().stream()
                .anyMatch(s -> s.getNombre().equalsIgnoreCase(solicitud.servicioSolicitado()));
        boolean disponible = agenda.obtenerEstado(profesional.getNombre()).equals("Disponible");

        if (cubreZona && ofreceServicio && disponible) {
            agenda.reservar(profesional.getNombre());
            System.out.println("Agendado con " + profesional.getNombre());
            return true;
        } else if (siguiente != null) {
            return siguiente.manejar(solicitud);
        }

        System.out.println("Ningún profesional disponible para la solicitud");
        return false;
    }
}
