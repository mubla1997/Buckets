package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Object;

import java.util.List;

public interface objectDAO {
    void createObject(Object object);
    void deleteObject(int id);
    List <Object> getAllObjects();
}
