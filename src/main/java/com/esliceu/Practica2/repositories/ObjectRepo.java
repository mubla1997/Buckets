package com.esliceu.Practica2.repositories;

import com.esliceu.Practica2.models.Object;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObjectRepo extends CrudRepository<Object,Integer> {
    Object save(Object object);
    void delete(Object object);
    List<Object> findAll();
    @Query("Select *  from object where directorio = :nombre")
    List<Object> getObjectsDirectory(@Param("nombre") String nombre);
    @Query("Select *  from object where id = :id")
    Object getObjectById(@Param("id") int id);
}
