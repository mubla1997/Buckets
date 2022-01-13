package com.esliceu.Practica2.services;

import com.esliceu.Practica2.models.Bucket;
import com.esliceu.Practica2.models.Object;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface Service {
    boolean userOk(String username, String password);
    boolean createUserOk(String username, String password, String realname, int age);
    boolean deleteUserOk(String username);
    boolean editUser(String username, String password, String realname, int age);
    boolean createBucket(String nombre, String owner,int id_user);
    boolean deleteBucket(int id);
    boolean createObject(String name, String directorio, String owner,byte[] fichero, int id_user);
    List<Bucket> findAllBuckets();
    List<Object> findAllObjects();
    int getIdUser(String username);
    List<Object> getObjectsFromDirectory(String nombre);
    Object getObjectById(int id);
}
