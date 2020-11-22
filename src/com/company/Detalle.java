package com.company;

public class Detalle {
    private int id;
    private int factura_id_fk;
    private int producto_id_fk;
    private int cantidad;
    private int precio;

    public Detalle(int id, int factura_id_fk, int producto_id_fk, int cantidad, int precio) {
        this.id = id;
        this.factura_id_fk = factura_id_fk;
        this.producto_id_fk = producto_id_fk;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactura_id_fk() {
        return factura_id_fk;
    }

    public void setFactura_id_fk(int factura_id_fk) {
        this.factura_id_fk = factura_id_fk;
    }

    public int getProducto_id_fk() {
        return producto_id_fk;
    }

    public void setProducto_id_fk(int producto_id_fk) {
        this.producto_id_fk = producto_id_fk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "id=" + id +
                ", factura_id_fk=" + factura_id_fk +
                ", producto_id_fk=" + producto_id_fk +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
