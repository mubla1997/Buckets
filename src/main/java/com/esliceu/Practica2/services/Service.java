package com.esliceu.Practica2.services;

import com.esliceu.Practica2.DAO.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class Service {
    @Autowired
    UserDAOImpl userDAO;

    public boolean UserOk(String username, String password){
        return false;
    }

    public boolean CreateUserOk(String username, String password) {
        return false;
    }
}
