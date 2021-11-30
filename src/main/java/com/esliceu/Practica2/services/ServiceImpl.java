package com.esliceu.Practica2.services;

import com.esliceu.Practica2.DAO.UserDAO;
import com.esliceu.Practica2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.esliceu.Practica2.services.Service {
    @Autowired
    UserDAO userDAO;

    List <User> userList = userDAO.getAllUsers();

    public boolean userOk(String username, String password){
        User user = userDAO.getUser(username, password);
        System.out.println("Username: " + username + " " + "Password: " + password);
        System.out.println("UserDatabase: " + user.getUsername() +" "+ "PasswordDatabase: " + user.getPasswd());
        if (user.getUsername().equals(username) && user.getPasswd().equals(password)){
            return true;
        }
        return  false;
    }

    @Override
    public boolean createUserOk(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User u = new User();
        u.setUsername(username);
        u.setPasswd(password);
        userDAO.createUser(u);
        return true;
    }


}
