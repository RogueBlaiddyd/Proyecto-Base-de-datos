package com.company.model;

public class ProductoYHistorial {
    private String nombreProducto;
    private int precio;
    private String fecha;

    public ProductoYHistorial(String nombreProducto, int precio, String fecha) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ProductoYHistorial{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
