package com.esliceu.Practica2.models;

import java.util.Date;

public class Bucket {
    int id;
    String nombre;
    String username_usuari;
    int id_user;
    String fecha;

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

    public String getUsername_usuari() {
        return username_usuari;
    }

    public void setUsername_usuari(String username_usuari) {
        this.username_usuari = username_usuari;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
