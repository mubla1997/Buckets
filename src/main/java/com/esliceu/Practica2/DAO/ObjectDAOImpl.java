package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.Object;
import com.esliceu.Practica2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectDAOImpl implements ObjectDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createObject(Object object) {
        jdbcTemplate.update("insert into object(nombre, directorio,username_usuari,fichero,id_user) values (?,?,?,?," +
                        "(select id from usuari where username = ?))",
                object.getNombre(), object.getDirectorio(), object.getUsername_usuari(), object.getFichero(), object.getUsername_usuari());
    }

    @Override
    public void deleteObject(Object object) {
        jdbcTemplate.update("delete from object where id = ?",
                object.getId());
    }

    @Override
    public List <Object> getAllObjects() {
        return jdbcTemplate.query("Select *  from object",
                new BeanPropertyRowMapper <Object>(Object.class));
    }

    @Override
    public List <Object> getObjectsDirectory(String directorio) {
        return jdbcTemplate.query("Select *  from object where directorio = ?",
                new BeanPropertyRowMapper <Object>(Object.class), directorio);
    }

    @Override
    public Object getObjectById(int id) {
        return jdbcTemplate.queryForObject("Select *  from object where id = ?",
                new BeanPropertyRowMapper <>(Object.class), id);

    }
}
