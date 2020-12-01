package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Categoria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCategoria {
    private MiConexion miLink;

    public DaoCategoria(MiConexion miLink) { this.miLink = miLink; }


    //INSERTS, UPDATES o DELETES
    public void addCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria VALUES ('"+categoria.getId()+"', '"+categoria.getNombreCat()+"')";
        Connection con = miLink.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla categoria-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteCategoria(int idPaBorrar){
        String sql = "DELETE FROM categoria WHERE id = '"+idPaBorrar+"'";
        Connection con = miLink.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla categoria-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //SELECTS ONLY
    public int numeroCat(){
        String sql = "SELECT COUNT(id) FROM categoria";
        int numeroCategorias = 0;
        Connection con = miLink.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int countObtenido = resultSet.getInt(1);
            numeroCategorias = countObtenido;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return numeroCategorias;
    }

    public int comprobarCat(String nombreComprobacion){
        String sql = "SELECT COUNT(id) FROM categoria WHERE nombre = '"+nombreComprobacion+"'";
        int numeroCatEncontradas = 0;
        Connection con = miLink.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int countObtenido = resultSet.getInt(1);
            numeroCatEncontradas = countObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return numeroCatEncontradas;
    }

    public int obtenerIdConcreto(String nombreComprobacion){
        String sql = "SELECT id FROM categoria WHERE nombre = '"+nombreComprobacion+"'";
        int idEncontrado = 0;
        Connection con = miLink.getCon();

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
