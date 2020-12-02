package com.company.DAO;

import com.company.miconexion.MiConexion;

import java.sql.*;

public class DaoValorTotal {

    private MiConexion miLink9;

    public DaoValorTotal(MiConexion miLink9) { this.miLink9 = miLink9; }


    //INSERTS, UPDATES O DELETES
    public void procedimientoInsert(int valorTotal, int idFactura){
        String sql = "{call descuento1('"+valorTotal+"', '"+idFactura+"')}";
        Connection con = miLink9.getCon();

        try {
            CallableStatement cst = con.prepareCall(sql);
            cst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void actualizarTotal(int nuevoTotal, int idValorT){
        String sql = "UPDATE valor_total SET totalprecios = '"+nuevoTotal+"' WHERE id = '"+idValorT+"'";
        Connection con = miLink9.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla valor_total-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //SELECTS ONLY
    public int totalConIva(int total, int idFactura){
        String sql = "SELECT devolucion_iva('"+total+"') FROM valor_total WHERE factura_id_fk = '"+idFactura+"'";
        int totalEncontrado = 0;
        Connection con = miLink9.getCon();

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

    public int idEspecifico(int idFactura){
        String sql = "SELECT id FROM valor_total WHERE factura_id_fk = '"+idFactura+"'";
        Connection con = miLink9.getCon();
        int idEncontrado = 0;

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int idObtenido = resultSet.getInt(1);
            idEncontrado = idObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return idEncontrado;
    }

}
