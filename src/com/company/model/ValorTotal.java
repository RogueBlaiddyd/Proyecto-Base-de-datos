package com.company.model;

public class ValorTotal {
    private int id;
    private int totalPrecios;
    private int factura_id_fk;

    public ValorTotal(int id, int totalPrecios, int factura_id_fk) {
        this.id = id;
        this.totalPrecios = totalPrecios;
        this.factura_id_fk = factura_id_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrecios() {
        return totalPrecios;
    }

    public void setTotalPrecios(int totalPrecios) {
        this.totalPrecios = totalPrecios;
    }

    public int getFactura_id_fk() {
        return factura_id_fk;
    }

    public void setFactura_id_fk(int factura_id_fk) {
        this.factura_id_fk = factura_id_fk;
    }

    @Override
    public String toString() {
        return "ValorTotal{" +
                "id=" + id +
                ", totalPrecios=" + totalPrecios +
                ", factura_id_fk=" + factura_id_fk +
                '}';
    }
}
