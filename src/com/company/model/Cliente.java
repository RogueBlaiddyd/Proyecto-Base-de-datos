package com.company.model;

public class Cliente {
    private int id;
    private String nombre;
    private String rut;
    private int preferencial;

    public Cliente(int id, String nombre, String rut, int preferencial) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.preferencial = preferencial;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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
                ", nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", preferencial=" + preferencial +
                '}';
    }
}
