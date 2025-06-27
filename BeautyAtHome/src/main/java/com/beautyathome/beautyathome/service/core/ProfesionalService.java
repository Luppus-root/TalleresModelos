package com.beautyathome.beautyathome.service.core;

import com.beautyathome.beautyathome.agenda.Agenda;
import com.beautyathome.beautyathome.agenda.state.Disponible;
import com.beautyathome.beautyathome.factory.FactoryProfesionalEstandar;
import com.beautyathome.beautyathome.factory.FactoryProfesionalPatrocinado;
import com.beautyathome.beautyathome.factory.ProfesionalFactory;
import com.beautyathome.beautyathome.model.Profesional;
import com.beautyathome.beautyathome.repository.ProfesionalRepository;
import com.beautyathome.beautyathome.repository.dto.ProfesionalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesionalService {

    private final ProfesionalRepository repo;
    private final Agenda agenda;

    public Profesional crearProfesional(ProfesionalDTO dto) {
        ProfesionalFactory factory = dto.patrocinado()
                ? new FactoryProfesionalPatrocinado(dto.marcaPatrocinadora())
                : new FactoryProfesionalEstandar();

        Profesional profesional = factory.crearProfesional(dto.nombre(), dto.experiencia());
        profesional.getZonasCobertura().addAll(dto.zonasCobertura());

        repo.save(profesional);

        agenda.cambiarEstado(
                profesional.getNombre(),
                new Disponible(agenda, profesional.getNombre())
        );

        return profesional;
    }

    public List<Profesional> listarTodos() {
        return repo.findAll();
    }

    public Profesional obtenerPorNombre(String nombre) {
        return repo.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }
}

