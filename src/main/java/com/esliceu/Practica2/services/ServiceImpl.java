package com.esliceu.Practica2.services;

import com.esliceu.Practica2.DAO.UserDAO;
import com.esliceu.Practica2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {
    @Autowired
    UserDAO userDAO;

    public boolean UserOk(String username, String password){
        User user = userDAO.getUser(username, password);
        if (user.getName().equals(username) && user.getPassword().equals(password)){
            return true;
        }
        return  false;
    }

    public boolean CreateUserOk(String username, String password) {
        return false;
    }
}
