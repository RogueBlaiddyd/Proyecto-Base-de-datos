package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Factura;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoFactura {
    private MiConexion miLink5;

    public DaoFactura(MiConexion miLink5) { this.miLink5 = miLink5; }

    public void addFactura(Factura factura){
        String sql = "INSERT INTO factura VALUES ('"+factura.getId()+"', '"+factura.getCliente_id_fk()+"', '"+factura.getFecha()+"', '"+factura.getPagado()+"')";
        Connection con = miLink5.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla factura-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
