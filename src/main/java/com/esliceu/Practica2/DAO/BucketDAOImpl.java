package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BucketDAOImpl implements BucketDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createBucket(Bucket bucket) {
        jdbcTemplate.update("insert into bucket(nombre,username_usuari,id_user) values (?,?," +
                "(select id from usuari where username = ?))", bucket.getNombre(),bucket.getUsername_usuari(),bucket.getUsername_usuari());
    }

    @Override
    public void deleteBucket(Bucket bucket) {
        jdbcTemplate.update("delete from bucket where id = ?",bucket.getId());
    }

    @Override
    public List <Bucket> getAllBuckets() {
        return jdbcTemplate.query("Select *  from bucket",
                new BeanPropertyRowMapper <Bucket>(Bucket.class));
    }
}
