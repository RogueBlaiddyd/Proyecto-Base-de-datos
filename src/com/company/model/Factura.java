package com.company.model;

public class Factura {
    private int id;
    private int cliente_id_fk;
    private String fecha;
    private int preferencial;

    public Factura(int id, int cliente_id_fk, String fecha, int preferencial) {
        this.id = id;
        this.cliente_id_fk = cliente_id_fk;
        this.fecha = fecha;
        this.preferencial = preferencial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id_fk() {
        return cliente_id_fk;
    }

    public void setCliente_id_fk(int cliente_id_fk) {
        this.cliente_id_fk = cliente_id_fk;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPreferencial() {
        return preferencial;
    }

    public void setPreferencial(int preferencial) {
        this.preferencial = preferencial;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente_id_fk=" + cliente_id_fk +
                ", fecha='" + fecha + '\'' +
                ", preferencial=" + preferencial +
                '}';
    }
}
