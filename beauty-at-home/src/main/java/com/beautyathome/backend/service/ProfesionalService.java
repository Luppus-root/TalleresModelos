package com.beautyathome.backend.service;

import com.beautyathome.backend.dto.ProfesionalDTO;
import com.beautyathome.backend.entity.Profesional;
import com.beautyathome.backend.repository.ProfesionalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProfesionalService {

    private final ProfesionalRepository profesionalRepository;

    public ProfesionalService(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    public List<ProfesionalDTO> searchProfesionales() {
        List<ProfesionalDTO> profesionales = new ArrayList<>();
        List<Profesional> profesionalSearch = profesionalRepository.findAll();
        for (Profesional p: profesionalSearch) {
            ProfesionalDTO profesional = mapToDTO(p);
            profesionales.add(profesional);
        }
        return profesionales;
    }

    private ProfesionalDTO mapToDTO(Profesional profesional) {
        return new ProfesionalDTO(profesional.getId(), profesional.getNombre(), profesional.getResumen(),
                profesional.getFotoUrl(), profesional.getEmail());
    }
}
