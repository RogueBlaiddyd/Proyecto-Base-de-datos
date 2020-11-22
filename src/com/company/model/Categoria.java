package com.company.model;

public class Categoria {
    private int id;
    private String nombreCat;

    public Categoria(int id, String nombreCat) {
        this.id = id;
        this.nombreCat = nombreCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombreCat='" + nombreCat + '\'' +
                '}';
    }
}
