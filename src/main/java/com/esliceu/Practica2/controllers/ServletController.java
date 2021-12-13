package com.esliceu.Practica2.controllers;

import com.esliceu.Practica2.DAO.BucketDAO;
import com.esliceu.Practica2.DAO.ObjectDAO;
import com.esliceu.Practica2.DAO.UserDAO;
import com.esliceu.Practica2.models.Bucket;
import com.esliceu.Practica2.models.Object;
import com.esliceu.Practica2.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ServletController {

    @Autowired
    Service service;

    @Autowired
    HttpSession session;

    @Autowired
    UserDAO userDAO;

    @Autowired
    BucketDAO bucketDAO;

    @Autowired
    ObjectDAO objectDAO;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/bucket")
    public String GetBucket(@SessionAttribute String username) {
        List <Bucket> listBucket = bucketDAO.getAllBuckets();
        session.setAttribute("listBucket", listBucket);
        return "bucket";
    }

    @PostMapping("/bucket")
    public String PostBucket(Model model, @SessionAttribute String username, @RequestParam String name) {

        if (service.createBucket(name, username, userDAO.getId(username))) {
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
        List <Object> listObject = objectDAO.getAllObjects();
        session.setAttribute("listObject", listObject);
        return "object";
    }

    @PostMapping("/object/{uri}")
    public String Postobject(Model model, @SessionAttribute String username, @RequestParam String name, @RequestParam String directory, @RequestParam byte[] file, @PathVariable String uri) {
        if (service.createObject(name, directory, username, file, userDAO.getId(username))) {

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
        List <Object> listObjectDirectory = objectDAO.getObjectsDirectory(urlDirectory);
        session.setAttribute("listObjectDirectory", listObjectDirectory);
        return "directory";
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

        if (service.createUserOk(username, password, realname, age)) {
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
    public String postSettings(Model model, @SessionAttribute String username, @RequestParam boolean delete, @RequestParam String password, @RequestParam String realname, @RequestParam int age) {
        if (delete) {
            service.deleteUserOk(username);
            model.addAttribute("message", "User deleted");
            return "redirect: /logout";
        }
        if (!delete) {
            service.editUser(username, password, realname, age);
            session.setAttribute("username", username);
            model.addAttribute("message", "User edited");
            return "Object";
        }
        model.addAttribute("message", "Failed to edit user");
        model.addAttribute("username", username);
        return "object";
    }

    @GetMapping("/logout")
    protected String logout() {
        session.invalidate();
        return "redirect: /login";
    }
}
