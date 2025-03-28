package com.modelos.creacionalestructural.entrada;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/entrada")
public class EntradaWeb extends Entrada {

    private Model model;

    @PostMapping("/capturar")
    public void capturar(@RequestParam String m) {
        model.addAttribute("mensaje", m);
    }

    @Override
    public String capturar() {
        return "";
    }
}
