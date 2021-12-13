package com.esliceu.Practica2.controllers;

import com.esliceu.Practica2.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    Service service;

    @Autowired
    HttpSession session;

    @GetMapping
    public String formulario() {
        return "loginForm";
    }

    @PostMapping
    public String checkLogin(Model model, @RequestParam String username, @RequestParam String password) {
        if (service.userOk(username, password)) {
            session.setAttribute("username", username);
            return "redirect: /bucket";
        }

        model.addAttribute("message", "Username or password incorrect");
        model.addAttribute("username", username);
        return "loginForm";
    }
}
