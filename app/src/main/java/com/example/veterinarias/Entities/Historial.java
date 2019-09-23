package com.example.veterinarias.Entities;

public class Historial {

    private int id;
    private String fecha;
    private String motivo;
    private  int idmascotas;
    private int idtipohistorial;

    public Historial() {
    }

    public Historial(String fecha, String motivo, int idmascotas, int idtipohistorial) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.idmascotas = idmascotas;
        this.idtipohistorial = idtipohistorial;
    }

    public Historial(int id, String fecha, String motivo, int idmascotas, int idtipohistorial) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.idmascotas = idmascotas;
        this.idtipohistorial = idtipohistorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdmascotas() {
        return idmascotas;
    }

    public void setIdmascotas(int idmascotas) {
        this.idmascotas = idmascotas;
    }

    public int getIdtipohistorial() {
        return idtipohistorial;
    }

    public void setIdtipohistorial(int idtipohistorial) {
        this.idtipohistorial = idtipohistorial;
    }

    public Historial(String fecha, String motivo) {
        this.fecha = fecha;
        this.motivo = motivo;
    }

}
