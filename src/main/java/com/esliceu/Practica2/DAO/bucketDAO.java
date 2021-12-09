package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Bucket;

import java.util.List;

public interface bucketDAO {
    void createBucket(Bucket bucket);
    void deleteBucker(int id);
    List <Bucket> getAllBuckets();
}
