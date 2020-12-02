package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCliente {
    private MiConexion miLink3;

    public DaoCliente(MiConexion miLink3) { this.miLink3 = miLink3; }

    //INSERTS, DELETES, O UPDATES
    public void addCliente(Cliente cliente){
        String sql = "INSERT INTO clientes VALUES('"+cliente.getId()+"', '"+cliente.getNombre()+"', '"+cliente.getRut()+"', '"+cliente.getPreferencial()+"')";
        Connection con = miLink3.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla cliente-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //SELECTS ONLY
    public int idEspecifico(String nombreCliente){
        String sql = "SELECT id FROM clientes WHERE nombre = '"+nombreCliente+"'";
        int idEncontrado = 0;
        Connection con = miLink3.getCon();

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
