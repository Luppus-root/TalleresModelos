package com.modelos.creacionalestructural.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(path = "/back", method = RequestMethod.GET)
    public String indexController(Model model) {
        Map<String, Object> map = new HashMap<>();
        return "index";
    }

}
