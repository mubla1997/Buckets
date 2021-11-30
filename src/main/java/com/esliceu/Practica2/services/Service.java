package com.esliceu.Practica2.services;

import com.esliceu.Practica2.models.User;

public interface Service {
    boolean userOk(String username, String password);
    boolean CreateUserOk(User user);
}
