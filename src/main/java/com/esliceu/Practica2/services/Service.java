package com.esliceu.Practica2.services;

public interface Service {
    boolean userOk(String username, String password);
    boolean createUserOk(String username, String password, String realname, int age);
    boolean deleteUserOk(String username);
}
