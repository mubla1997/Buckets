package com.esliceu.Practica2.services;

public interface Service {
    boolean userOk(String username, String password);
    boolean createUserOk(String username, String password, String realname, int age);
    boolean deleteUserOk(String username);
    boolean createBucket(String nombre,String owner,int id_user);
    boolean deleteBucket(int id);
    boolean createObject(String name, String directorio, String owner,byte[] fichero, int id_user);

}
