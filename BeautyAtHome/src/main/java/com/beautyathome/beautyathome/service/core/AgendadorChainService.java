package com.beautyathome.beautyathome.service.core;

import com.beautyathome.beautyathome.agenda.Agenda;
import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.repository.ProfesionalRepository;
import com.beautyathome.beautyathome.service.chain.ManejadorProfesional;
import com.beautyathome.beautyathome.service.dto.AgendamientoSolicitud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendadorChainService {

    private final ProfesionalRepository repo;
    private final Agenda agenda;

    public boolean procesarSolicitud(AgendamientoSolicitud solicitud) {
        List<Profesional> candidatos = repo.findAll();
        if (candidatos.isEmpty()) return false;

        List<ManejadorProfesional> nodos = candidatos.stream()
                .map(p -> new ManejadorProfesional(p, agenda))
                .toList();

        for (int i = 0; i < nodos.size() - 1; i++) {
            nodos.get(i).establecerSiguiente(nodos.get(i + 1));
        }

        return nodos.get(0).manejar(solicitud);
    }
}
