package com.company.model;

public class Factura {
    private int id;
    private int cliente_id_fk;
    private String fecha;
    private int pagado;

    public Factura(int id, int cliente_id_fk, String fecha, int pagado) {
        this.id = id;
        this.cliente_id_fk = cliente_id_fk;
        this.fecha = fecha;
        this.pagado = pagado;
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

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente_id_fk=" + cliente_id_fk +
                ", fecha='" + fecha + '\'' +
                ", pagado=" + pagado +
                '}';
    }
}
