package com.beautyathome.backend.controller;

import com.beautyathome.backend.dto.ProfesionalDTO;
import com.beautyathome.backend.dto.ServicioDTO;
import com.beautyathome.backend.repository.ReseñaRepository;
import com.beautyathome.backend.service.ProfesionalService;
import com.beautyathome.backend.service.ReseñaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path ="/beautyathome/reseñas")
public class ReseñaController {

    private final ProfesionalService profesionalService;
    private final ReseñaService reseñaService;

    public ReseñaController(ProfesionalService profesionalService, ReseñaService reseñaService) {
        this.profesionalService = profesionalService;
        this.reseñaService = reseñaService;
    }
    @GetMapping("/reseñar")
    public String reseñar(Model model, Authentication authentication) {
        String username = authentication.getName();
        model.addAttribute("username", username);

        List<ProfesionalDTO> profesionales = profesionalService.searchProfesionales();
        model.addAttribute("vuelos", profesionales);
        return "reseñar";

    }
}
