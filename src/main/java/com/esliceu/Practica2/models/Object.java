package com.esliceu.Practica2.models;

public class Object {
    int id;
    String nombre;
    String directorio;
    String username_usuari;
    byte[] fichero;
    String bucket_name;
    int id_user;
    int id_bucket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public String getUsername_usuari() {
        return username_usuari;
    }

    public void setUsername_usuari(String username_usuari) {
        this.username_usuari = username_usuari;
    }

    public byte[] getFichero() {
        return fichero;
    }

    public void setFichero(byte[] fichero) {
        this.fichero = fichero;
    }

    public String getBucket_name() {
        return bucket_name;
    }

    public void setBucket_name(String bucket_name) {
        this.bucket_name = bucket_name;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_bucket() {
        return id_bucket;
    }

    public void setId_bucket(int id_bucket) {
        this.id_bucket = id_bucket;
    }
}
