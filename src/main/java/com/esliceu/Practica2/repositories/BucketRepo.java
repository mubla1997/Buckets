package com.esliceu.Practica2.repositories;

import com.esliceu.Practica2.models.Bucket;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BucketRepo extends CrudRepository<Bucket,Integer> {
   Bucket save(Bucket bucket);
   void delete(Bucket bucket);
   List<Bucket> findAll();
   @Query("Select id from bucket where nombre = :nombre")
   int getId(@Param("nombre") String nombre);
}
