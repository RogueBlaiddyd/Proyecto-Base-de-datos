package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCategoria {
    private MiConexion miLink;

    public DaoCategoria(MiConexion miLink) { this.miLink = miLink; }

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

}
