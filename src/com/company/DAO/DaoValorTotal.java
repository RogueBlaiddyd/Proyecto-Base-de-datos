package com.company.DAO;

import com.company.miconexion.MiConexion;

import java.sql.*;

public class DaoValorTotal {

    private MiConexion miLink9;

    public DaoValorTotal(MiConexion miLink9) { this.miLink9 = miLink9; }

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

}
