package com.beautyathome.backend.controller;

import com.beautyathome.backend.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(path ="/beautyathome")
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String authController(Model model, Authentication authentication) {

        String username = authentication.getName();

        model.addAttribute("username", username);
        return "home";
    }

}
