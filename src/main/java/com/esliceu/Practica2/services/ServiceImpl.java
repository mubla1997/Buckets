package com.esliceu.Practica2.services;

import com.esliceu.Practica2.DAO.BucketDAO;
import com.esliceu.Practica2.DAO.ObjectDAO;
import com.esliceu.Practica2.DAO.UserDAO;
import com.esliceu.Practica2.models.Bucket;
import com.esliceu.Practica2.models.Object;
import com.esliceu.Practica2.models.User;
import com.esliceu.Practica2.utils.GeneratorHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.esliceu.Practica2.services.Service {
    @Autowired
    UserDAO userDAO;

    @Autowired
    ObjectDAO objectDAO;

    @Autowired
    BucketDAO bucketDAO;

    public boolean userOk(String username, String password){
        if (username == null || password == null) return false;

        try {
            User user = userDAO.getUser(username, password);

            password = GeneratorHash.generaHash(password);

            return user.getUsername().equals(username) && user.getPasswd().equals(password);

        }catch(org.springframework.dao.EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean createUserOk(String username, String password, String realname, int age) {
        List <User> userList = userDAO.getAllUsers();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User u = new User();
        u.setUsername(username);
        password = GeneratorHash.generaHash(password);
        u.setPasswd(password);
        u.setRealname(realname);
        u.setAge(age);
        userDAO.createUser(u);
        return true;
    }
    @Override
    public boolean deleteUserOk(String username) {
            User user = new User();
            user.setUsername(username);
            userDAO.deleteUser(user);
            return true;

    }

    @Override
    public boolean createBucket(String nombre,String owner, int id_user) {
        List <Bucket> bucketList = bucketDAO.getAllBuckets();

        for(Bucket bucket : bucketList){
            if(bucket.getNombre().equals(nombre)){
                return false;
            }
        }
        Bucket b = new Bucket();
        b.setNombre(nombre);
        b.setUsername_usuari(owner);
        b.setId_user(id_user);
        bucketDAO.createBucket(b);
        return true;
    }

    @Override
    public boolean deleteBucket(int id) {
        Bucket bucket = new Bucket();
        bucket.setId(id);
        bucketDAO.deleteBucket(bucket);
        return true;

    }

    @Override
    public boolean createObject(String nombre, String directorio, String owner, byte[] fichero, int id_user) {
        List <Object> objectList = objectDAO.getAllObjects();

        for (Object object : objectList) {
            if (object.getNombre().equals(nombre)) {
                return false;
            }
        }
        if(nombre == null) return false;
        if(directorio == null) return false;
        if(fichero == null) return false;

       Object o = new Object();
        o.setNombre(nombre);
        o.setDirectorio(directorio);
        o.setUsername_usuari(owner);
        o.setFichero(fichero);
        o.setId_user(id_user);
        objectDAO.createObject(o);
        return true;
    }


}
