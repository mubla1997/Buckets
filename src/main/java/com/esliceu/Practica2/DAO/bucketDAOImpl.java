package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class bucketDAOImpl implements bucketDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createBucket(Bucket bucket) {
        jdbcTemplate.update("insert into bucket (name,owner) values (?,?)",
                bucket.getName(), bucket.getOwner());
    }

    @Override
    public void deleteBucker(int id) {
    }
}
