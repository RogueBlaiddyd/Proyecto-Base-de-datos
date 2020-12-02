package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Detalle;

import java.sql.*;

public class DaoDetalle {

    public MiConexion miLink4;

    public DaoDetalle(MiConexion miLink4) { this.miLink4 = miLink4; }

    //INSERT, DELETE O UPDATE
    public void addDetalle(Detalle detalle){
        String sql = "INSERT INTO detalle VALUES ('"+detalle.getId()+"', '"+detalle.getFactura_id_fk()+"', '"+detalle.getProducto_id_fk()+"', '"+detalle.getCantidad()+"', '"+detalle.getPrecio()+"')";
        Connection con = miLink4.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla detalle-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //SELECTS ONLY
    public int precioTotal(int idFactura){
        String sql = "SELECT SUM(precio) FROM detalle WHERE factura_id_fk = '"+idFactura+"'";
        int totalEncontrado = 0;
        Connection con = miLink4.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int totalObtenido = resultSet.getInt(1);
            totalEncontrado = totalObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalEncontrado;
    }

}
