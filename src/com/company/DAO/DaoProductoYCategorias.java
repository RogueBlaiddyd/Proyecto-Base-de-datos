package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.ProductoYCategorias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DaoProductoYCategorias {

    private MiConexion miLink8;

    public DaoProductoYCategorias(MiConexion miLink8) { this.miLink8 = miLink8; }

    public List<ProductoYCategorias> getAllData(){
        String sql = "SELECT producto.nombre, categoria.nombre, producto.precio FROM producto INNER JOIN categoria ON categoria.id = producto.categoria_id_fk";
        List<ProductoYCategorias> list = new ArrayList<>();
        Connection con = miLink8.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String nombreProd = resultSet.getString("nombre");
                String nombreCat = resultSet.getString("Nombre");
                int precioProd = resultSet.getInt("precio");

                ProductoYCategorias productoYCategorias = new ProductoYCategorias(nombreProd, nombreCat, precioProd);
                list.add(productoYCategorias);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }


}
