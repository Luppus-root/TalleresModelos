package com.modelos.creacionalestructural.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(path = "/back", method = RequestMethod.GET)
    public String indexController(Model model) {
        System.out.println("El controlador back ha sido llamado");
        return "index";
    }
}