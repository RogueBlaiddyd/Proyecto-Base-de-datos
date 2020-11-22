package com.company.model;

public class Historial_de_Precios {
    private int id;
    private double precioAlterado;
    private int producto_id_fk;

    public Historial_de_Precios(int id, double precioAlterado, int producto_id_fk) {
        this.id = id;
        this.precioAlterado = precioAlterado;
        this.producto_id_fk = producto_id_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioAlterado() {
        return precioAlterado;
    }

    public void setPrecioAlterado(double precioAlterado) {
        this.precioAlterado = precioAlterado;
    }

    public int getProducto_id_fk() {
        return producto_id_fk;
    }

    public void setProducto_id_fk(int producto_id_fk) {
        this.producto_id_fk = producto_id_fk;
    }

    @Override
    public String toString() {
        return "Historial_de_Precios{" +
                "id=" + id +
                ", precioAlterado=" + precioAlterado +
                ", producto_id_fk=" + producto_id_fk +
                '}';
    }
}
