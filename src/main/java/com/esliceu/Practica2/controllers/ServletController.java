package com.esliceu.Practica2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServletController {
    @GetMapping("/")
    public String home(){
        return "home";
    }


}
