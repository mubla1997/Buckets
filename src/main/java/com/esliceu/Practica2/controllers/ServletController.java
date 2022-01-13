package com.esliceu.Practica2.controllers;


import com.esliceu.Practica2.models.Bucket;
import com.esliceu.Practica2.models.Object;
import com.esliceu.Practica2.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ServletController {

    private ServiceImpl serviceImpl;

    @Autowired
    ServletController(ServiceImpl serviceImpl){
        this.serviceImpl = serviceImpl;
    }

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/bucket")
    public String GetBucket(@SessionAttribute String username) {
        List <Bucket> listBucket = serviceImpl.findAllBuckets();
        session.setAttribute("listBucket", listBucket);
        return "bucket";
    }

    @PostMapping("/bucket")
    public String PostBucket(Model model, @SessionAttribute String username, @RequestParam String name) {

        if (serviceImpl.createBucket(name, username, serviceImpl.getIdUser(username))) {
            model.addAttribute("message", "Bucket created");
            session.setAttribute("username", username);

            return ("redirect: /bucket");
        }
        model.addAttribute("message", "Failed to create bucket");
        model.addAttribute("username", username);
        return "redirect: /bucket";
    }

    @GetMapping("/object/{uri}")
    public String GetObject(@SessionAttribute String username, @PathVariable String uri) {
        List <Object> listObject = serviceImpl.findAllObjects();
        session.setAttribute("listObject", listObject);
        return "object";
    }

    @PostMapping("/object/{uri}")
    public String Postobject(Model model, @SessionAttribute String username, @RequestParam String name, @RequestParam String directory, @RequestParam byte[] file, @PathVariable String uri) {
        if (serviceImpl.createObject(name, directory, username, file, serviceImpl.getIdUser(username))) {

            model.addAttribute("message", "Object created");
            session.setAttribute("username", username);
            return "redirect: /object/{uri}";
        }
        model.addAttribute("message", "Failed to create object");
        model.addAttribute("username", username);
        return "object/{uri}";
    }

    @GetMapping("/object/{uri}/**")
    public String getDirectory(Model model, @SessionAttribute String username, @PathVariable String uri, HttpServletRequest request) {


        String url = request.getRequestURL().toString();
        url.replace("http://localhost:8080/object/" + uri + "/", "");

        String urlDirectory = request.getRequestURL().toString();
        urlDirectory.replace("http://localhost:8080/object/", "");
        List <Object> listObjectDirectory = serviceImpl.getObjectsFromDirectory(urlDirectory);
        session.setAttribute("listObjectDirectory", listObjectDirectory);
        return "directory";
    }

    @GetMapping("/download/{uri}")
    public String getDownload(Model model, @SessionAttribute String username, @PathVariable int uri){
        Object object = serviceImpl.getObjectById(uri);
        model.addAttribute("object", object);
        return "download";
    }

    @GetMapping("/register")
    public String GetRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String PostRegister(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String repPass, @RequestParam String realname, @RequestParam int age) {
        if (!password.equals(repPass)) {
            model.addAttribute("message", "Password error");
            model.addAttribute("username", username);
            return "register";
        }

        if (serviceImpl.createUserOk(username, password, realname, age)) {
            session.setAttribute("username", username);
            model.addAttribute("message", "User created");
            return "loginForm";
        }

        model.addAttribute("message", "Failed to create user");
        model.addAttribute("username", username);
        return "register";
    }

    @GetMapping("/settings")
    public String getSettings() {
        return "settings";
    }

    @PostMapping("/settings")
    public String postSettings(Model model, @SessionAttribute String username, @RequestParam boolean delete, @RequestParam(required = false) String password, @RequestParam(required = false) String realname, @RequestParam(required = false) int age) {
        if (delete) {
            serviceImpl.deleteUserOk(username);
            model.addAttribute("message", "User deleted");
            return "redirect: /logout";
        }
        if (!delete) {
            serviceImpl.editUser(username, password, realname, age);
            session.setAttribute("username", username);
            model.addAttribute("message", "User edited");
            return "bucket";
        }
        model.addAttribute("message", "Failed to edit user");
        model.addAttribute("username", username);
        return "bucket";
    }

    @GetMapping("/logout")
    protected String logout() {
        session.invalidate();
        return "redirect: /login";
    }
}
