package com.modelos.creacionalestructural.salida;

import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller; // Importa Controller

@Controller // Cambia a Controller
@RequestMapping("/salida")
@Getter
public class SalidaWeb extends Salida {

    @GetMapping("/mostrar")
    public String salida(@RequestParam("m") String m, Model model) { // Especifica el nombre del parámetro
        model.addAttribute("mensaje", m);
        return "salida"; // Devuelve el nombre de la vista
    }

    @Override
    public void mostrar(String m) {
        // ...
    }
}