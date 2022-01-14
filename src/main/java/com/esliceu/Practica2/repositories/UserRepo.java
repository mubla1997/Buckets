package com.esliceu.Practica2.repositories;

import com.esliceu.Practica2.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
    @Query("Select * from usuari where username= :user")
    User getUser(@Param("user") String username);
    List<User> findAll();
    User save(User user);
    void delete(User user);
    @Query("Select id from usuari where username = :username")
    int getId(@Param("username")String username);
    @Query("update usuari set username = :username, passwd = :passwd, realname = :realname, edad = :edad where username = :user ")
    void editUser(@Param("username") String username, @Param("passwd") String passwd, @Param("realname") String realname,
                  @Param("edad") int age, @Param("user") User user );
}
