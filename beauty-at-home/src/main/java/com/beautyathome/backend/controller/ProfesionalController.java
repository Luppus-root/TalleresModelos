package com.beautyathome.backend.controller;

import com.beautyathome.backend.repository.ProfesionalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(path ="/beautyathome/profesionales")
public class ProfesionalController {

    private final ProfesionalRepository profesionalRepository;

    public ProfesionalController(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

}
