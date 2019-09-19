package com.example.veterinarias.Entities;

public class Mascotas {
    private int id;
    private String nombre;
    private String sexo;
    private String raza;
    private String tipo;
    private int idusuario;


    public Mascotas() {
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Mascotas(int id, String nombre, String sexo, String raza, String tipo, int idusuario) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.raza = raza;
        this.tipo = tipo;
        this.idusuario = idusuario;
    }

    public Mascotas(String nombre, String sexo, String raza, String tipo, int idusuario) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.raza = raza;
        this.tipo = tipo;
        this.idusuario = idusuario;
    }

    public Mascotas(int id, String nombre, String sexo, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.raza = raza;
    }
}
