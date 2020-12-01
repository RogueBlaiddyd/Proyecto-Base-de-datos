package com.company.model;

public class ProductoYCategorias {
    private String nombreProducto;
    private String nombreCategoria;
    private int precio;

    public ProductoYCategorias(String nombreProducto, String nombreCategoria, int precio) {
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoYCategorias{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", precio=" + precio +
                '}';
    }
}
