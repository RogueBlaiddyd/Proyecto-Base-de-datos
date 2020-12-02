package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Factura;

import java.sql.*;

public class DaoFactura {
    private MiConexion miLink5;

    public DaoFactura(MiConexion miLink5) { this.miLink5 = miLink5; }

    //INSERTS, DELETES O UPDATES
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

    //SELECTS ONLY
    public int idFactEspecifico(int idCliente){
        String sql = "SELECT id FROM factura WHERE clientes_id_fk = '"+idCliente+"'";
        int idEncontrado = 0;
        Connection con = miLink5.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int idObtenido = resultSet.getInt(1);
            idEncontrado = idObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  idEncontrado;
    }

    public void procedimientoPagado(int idFactura){
        String sql = "{call pagado1('"+idFactura+"')}";
        Connection con = miLink5.getCon();

        try {
            CallableStatement cst = con.prepareCall(sql);
            cst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
