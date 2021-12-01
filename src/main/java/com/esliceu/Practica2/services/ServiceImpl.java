package com.esliceu.Practica2.services;

import com.esliceu.Practica2.DAO.UserDAO;
import com.esliceu.Practica2.models.User;
import com.esliceu.Practica2.utils.GeneratorHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.esliceu.Practica2.services.Service {
    @Autowired
    UserDAO userDAO;

    public boolean userOk(String username, String password){
        User user = userDAO.getUser(username, password);

        if (username == null || password == null) return false;
        password = GeneratorHash.generaHash(password);
        return user.getUsername().equals(username) && user.getPasswd().equals(password);
    }

    @Override
    public boolean createUserOk(String username, String password) {
        List <User> userList = userDAO.getAllUsers();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User u = new User();
        u.setUsername(username);
        password = GeneratorHash.generaHash(password);
        u.setPasswd(password);
        userDAO.createUser(u);
        return true;
    }


}
