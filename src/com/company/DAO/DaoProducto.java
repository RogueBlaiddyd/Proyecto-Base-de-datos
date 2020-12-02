package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoProducto {
    private MiConexion miLink7;

    public DaoProducto(MiConexion miLink7) { this.miLink7 = miLink7; }

    //UPDATES, INSERTS, O DELETES
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

    public void updatePrecio(int nuevoPrecio, int idModificacion){
        String sql = "UPDATE producto SET precio = '"+nuevoPrecio+"' WHERE id = '"+idModificacion+"'";
        Connection con = miLink7.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla producto-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteProducto(int idPaBorrar){
        String sql = "DELETE FROM producto WHERE id = '"+idPaBorrar+"'";
        Connection con = miLink7.getCon();

        try {
            Statement statement = con.createStatement();
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Cantidad de filas afectadas -Tabla producto-: "+filasAfectadas);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //SELECTS ONLY
    public int obtenerIdEspecifico(String productoABuscar){
        String sql = "SELECT id FROM producto WHERE nombre = '"+productoABuscar+"'";
        int idEncontrado = 0;
        Connection con = miLink7.getCon();

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

    public int countIdCatEnProd(int idComprobar){
        String sql = "SELECT COUNT(producto.categoria_id_fk) FROM producto INNER JOIN categoria ON categoria.id = producto.categoria_id_fk WHERE categoria.id = '"+idComprobar+"'";
        int countEncontrado = 0;
        Connection con = miLink7.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int countObtenido = resultSet.getInt(1);
            countEncontrado = countObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countEncontrado;
    }

    public int precioEnEspecifico(String nombreProducto){
        String sql = "SELECT precio FROM producto WHERE nombre = '"+nombreProducto+"'";
        int precioEncontrado = 0;
        Connection con = miLink7.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int precioObtenido = resultSet.getInt(1);
            precioEncontrado = precioObtenido;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return precioEncontrado;
    }

}
