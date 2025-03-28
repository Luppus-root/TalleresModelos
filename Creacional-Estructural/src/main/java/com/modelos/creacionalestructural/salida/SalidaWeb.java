package com.modelos.creacionalestructural.salida;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salida")
@Getter
public class SalidaWeb extends Salida {

    private Model model;

    @PostMapping("/mostrar")
    public String salida(@RequestParam String m) {
        // Procesa los datos enviados desde el formulario web
        model.addAttribute("mensaje", m);
        return "salida";
    }

    @Override
    public void mostrar(String m) {

    }
}
