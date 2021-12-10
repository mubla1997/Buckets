package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.User;

import java.util.List;

public interface UserDAO {
    User getUser(String username , String password);
    List<User> getAllUsers();
    void createUser(User user);
    void deleteUser(User user);
}
