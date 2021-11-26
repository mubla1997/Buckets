package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.User;

import java.util.List;

public interface UserDAO {
    User getUser(String username);
    List<User> getAllUsers();
    void createUser(User user);
}
