package com.company.model;

public class Cliente {
    private int id;
    private String rut;
    private String nombre;
    private int preferencial;

    public Cliente(int id, String rut, String nombre, int preferencial) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.preferencial = preferencial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPreferencial() {
        return preferencial;
    }

    public void setPreferencial(int preferencial) {
        this.preferencial = preferencial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", preferencial=" + preferencial +
                '}';
    }
}
