package com.esliceu.Practica2.DAO;

import com.esliceu.Practica2.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String username, String password) {
        return jdbcTemplate.queryForObject("Select * from usuari where username=?",
                new BeanPropertyRowMapper <>(User.class), username);
    }
    @Override
    public List <User> getAllUsers() {
        return jdbcTemplate.query("Select * from usuari",
                new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("insert into usuari (username,passwd,realname,edad) values (?,?,?,?)",
        user.getUsername(),user.getPasswd(),user.getRealname(),user.getAge());
    }

    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("delete from usuari where username = ? ",
                user.getUsername());
    }

    @Override
    public int getId(String username) {
        jdbcTemplate.queryForObject("Select id from usuari where username = ?",
                new BeanPropertyRowMapper <>(User.class), username);
        return 0;
    }
}
