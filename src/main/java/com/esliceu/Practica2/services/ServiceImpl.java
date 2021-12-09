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
        if (username == null || password == null) return false;
        try {

            User user = userDAO.getUser(username, password);

            password = GeneratorHash.generaHash(password);

            return user.getUsername().equals(username) && user.getPasswd().equals(password);
        }catch(org.springframework.dao.EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean createUserOk(String username, String password, String realname, int age) {
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
        u.setRealname(realname);
        u.setAge(age);
        userDAO.createUser(u);
        return true;
    }


}
