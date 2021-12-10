package com.esliceu.Practica2.controllers;

import com.esliceu.Practica2.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.ServletOutputStream;
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
    public String GetObject(@SessionAttribute String username){

        return "object";
    }


    @PostMapping("/object")
    public String Postobject(@SessionAttribute String username){

        return "object";}

    @GetMapping("/register")
    public String GetRegister(){
        return "register";}

    @PostMapping("/register")
    public String PostRegister(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String repPass, @RequestParam String realname, @RequestParam int age){
        if(!password.equals(repPass)){
            model.addAttribute("message","Password error");
            model.addAttribute("username",username);
            return "register";
        }

        if (service.createUserOk(username , password, realname, age)){
            session.setAttribute("username",username);
            model.addAttribute("message", "User created");
            return "loginForm";
        }

        model.addAttribute("message","Failed to create user");
        model.addAttribute("username",username);
        return "register";
    }
    @GetMapping("/settings")
    public String getSettings(){
        return "settings";
    }
    @PostMapping("/settings")
    public String postSettings(Model model, @SessionAttribute String username, @RequestParam boolean delete){
        if(delete) {
            service.deleteUserOk(username);
            model.addAttribute("message","User deleted");
            return "redirect: /logout";
        }
        return "redirect: /object";
    }


    @GetMapping("/logout")
    protected String logout(){
        session.invalidate();
        return "redirect: /login";
    }
}
