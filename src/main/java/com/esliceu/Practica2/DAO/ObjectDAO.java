package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Object;

import java.util.List;

public interface ObjectDAO {
    void createObject(Object object);

    void deleteObject(Object object);

    List <Object> getAllObjects();

    List <Object> getObjectsDirectory(String directorio);

    Object getObjectById(int id);

}
