package com.modelos.creacionalestructural.entrada;

import com.modelos.creacionalestructural.CreacionalEstructuralApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrada")
public class EntradaWeb extends Entrada {

    @PostMapping("/capturar")
    public void capturar(@RequestParam String m, Model model) { // Model as a parameter
        model.addAttribute("mensaje", m);
    }

    @Override
    public String capturar() {
        SpringApplication.run(CreacionalEstructuralApplication.class);

        return "";

    }
}