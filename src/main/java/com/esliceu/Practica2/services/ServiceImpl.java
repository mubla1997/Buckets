package com.esliceu.Practica2.services;


import com.esliceu.Practica2.models.Bucket;
import com.esliceu.Practica2.models.Object;
import com.esliceu.Practica2.models.User;
import com.esliceu.Practica2.repositories.BucketRepo;
import com.esliceu.Practica2.repositories.ObjectRepo;
import com.esliceu.Practica2.repositories.UserRepo;
import com.esliceu.Practica2.utils.GeneratorHash;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceImpl implements com.esliceu.Practica2.services.Service {
    BucketRepo bucketRepo;
    ObjectRepo objectRepo;
    UserRepo userRepo;

    ServiceImpl(BucketRepo bucketRepo, ObjectRepo objectRepo,UserRepo userRepo){
        this.bucketRepo = bucketRepo;
        this.objectRepo = objectRepo;
        this.userRepo = userRepo;
    }

    public boolean userOk(String username, String password){
        if (username == null || password == null) return false;

        try {
            User user = userRepo.getUser(username, password);

            password = GeneratorHash.generaHash(password);

            return user.getUsername().equals(username) && user.getPasswd().equals(password);

        }catch(org.springframework.dao.EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean createUserOk(String username, String password, String realname, int age) {
        List <User> userList = userRepo.findAll();

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
        userRepo.save(u);
        return true;
    }
    @Override
    public boolean deleteUserOk(String username) {
            User user = new User();
            user.setUsername(username);
            userRepo.delete(user);
            return true;

    }

    @Override
    public boolean editUser(String username, String password, String realname, int age) {
        List <User> userList = userRepo.findAll();

        for (User user : userList) {

            if (user.getUsername().equals(username)) {
                User u = new User();
                u.setUsername(user.getUsername());
                if (password == "") {
                    u.setPasswd(user.getPasswd());
                }
                password = GeneratorHash.generaHash(password);
                u.setPasswd(password);

                if(realname.equals("")){
                    u.setRealname(user.getRealname());
                }
                u.setRealname(realname);

                if(age == -1){
                    u.setAge(user.getAge());
                }
                u.setAge(age);

                userRepo.editUser(username,password,realname,age,u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createBucket(String nombre, String owner, int id_user) {
        List <Bucket> bucketList = bucketRepo.findAll();
        LocalDate localeDate = LocalDate.now();

        for(Bucket bucket : bucketList){
            if(bucket.getNombre().equals(nombre)){
                return false;
            }
            if(nombre == null) return false;
        }
        Bucket b = new Bucket();
        b.setNombre(nombre);
        b.setUsername_usuari(owner);
        b.setFecha(String.valueOf(localeDate));
        b.setId_user(id_user);
        bucketRepo.save(b);
        return true;
    }

    @Override
    public boolean deleteBucket(int id) {
        Bucket bucket = new Bucket();
        bucket.setId(id);
        bucketRepo.delete(bucket);
        return true;

    }
    @Override
    public boolean createObject(String nombre, String directorio, String owner, byte[] fichero, int id_user) {
        List <Object> objectList = objectRepo.findAll();
            for (Object object : objectList) {
                if (object.getNombre().equals(nombre)) {
                    return false;
                }
            }
            if (nombre == null) return false;
            if (directorio == null) return false;
            if (fichero == null) return false;

            Object o = new Object();
            o.setNombre(nombre);
            o.setDirectorio(directorio);
            o.setUsername_usuari(owner);
            o.setFichero(fichero);
            o.setId_user(id_user);
            objectRepo.save(o);
            return true;
    }

    @Override
    public List <Bucket> findAllBuckets() {
        return bucketRepo.findAll();
    }

    @Override
    public List <Object> findAllObjects() {
        return objectRepo.findAll();
    }

    @Override
    public int getIdUser(String username) {
        return userRepo.getId(username);
    }

    @Override
    public List <Object> getObjectsFromDirectory(String nombre) {
        return objectRepo.getObjectsDirectory(nombre);
    }

    @Override
    public Object getObjectById(int id) {
        return objectRepo.getObjectById(id);
    }


}
