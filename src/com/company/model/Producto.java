package com.company.model;

public class Producto {
    private int id;
    private String nombre;
    private int categoria_id_fk;
    private double precio;

    public Producto(int id, String nombre, int categoria_id_fk, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria_id_fk = categoria_id_fk;
        this.precio = precio;
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

    public int getCategoria_id_fk() {
        return categoria_id_fk;
    }

    public void setCategoria_id_fk(int categoria_id_fk) {
        this.categoria_id_fk = categoria_id_fk;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria_id_fk=" + categoria_id_fk +
                ", precio=" + precio +
                '}';
    }
}
