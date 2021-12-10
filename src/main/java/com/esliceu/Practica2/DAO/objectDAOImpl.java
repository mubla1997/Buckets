package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class objectDAOImpl implements objectDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createObject(Object object) {
        jdbcTemplate.update("insert into bucket (name,owner) values (?,?)",
                object.getName(), object.getOwner());
    }

    @Override
    public void deleteObject(int id) {
    }

    @Override
    public List <Object> getAllObjects() {
        return jdbcTemplate.query("Select * from bucket",
                new BeanPropertyRowMapper <Object>(Object.class));
    }
}
