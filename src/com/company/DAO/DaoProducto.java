package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoProducto {
    private MiConexion miLink7;

    public DaoProducto(MiConexion miLink7) { this.miLink7 = miLink7; }

    public void addProducto(Producto producto){
        String sql = "INSERT INTO producto VALUES ('"+producto.getId()+"', '"+producto.getNombre()+"', '"+producto.getCategoria_id_fk()+"', '"+producto.getPrecio()+"')";
        Connection con = miLink7.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla Producto-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
