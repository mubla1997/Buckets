package com.esliceu.Practica2.controllers;

import com.esliceu.Practica2.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ServletController {

    @Autowired
    Service service;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/object")
    public String GetObject(){return "object";}

    @PostMapping("/object")
    public String Postobject(){return "object";}

    @GetMapping("/register")
    public String GetRegister(){return "register";}

    @PostMapping("/register")
    public String PostRegister(Model model, @RequestParam String username, @RequestParam String password){
        if (service.createUserOk(username , password)){
            session.setAttribute("username",username);
            model.addAttribute("message", "User created");
            return "loginForm";
        }

        model.addAttribute("message","Failed to create user");
        model.addAttribute("username",username);
        return "register";
    }
}
