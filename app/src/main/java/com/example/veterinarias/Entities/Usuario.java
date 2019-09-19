package com.example.veterinarias.Entities;

public class Usuario {
    private int id;
    private String user;
    private String passwoord;
    private String nombre;

    public Usuario() {
    }

    public Usuario(String user, String passwoord) {
        this.user = user;
        this.passwoord = passwoord;
    }

    public Usuario(String user, String passwoord, String nombre) {
        this.user = user;
        this.passwoord = passwoord;
        this.nombre = nombre;
    }

    public Usuario(int id, String user, String passwoord, String nombre) {
        this.id = id;
        this.user = user;
        this.passwoord = passwoord;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
