package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List <User> getAllUsers() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }
}
