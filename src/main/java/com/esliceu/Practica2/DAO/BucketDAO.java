package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Bucket;

import java.util.List;

public interface BucketDAO {
    void createBucket(Bucket bucket);
    void deleteBucket(Bucket bucket);
    List <Bucket> getAllBuckets();
    int getId(String nombre);

}
