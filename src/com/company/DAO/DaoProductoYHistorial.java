package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.ProductoYHistorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoProductoYHistorial {

    private MiConexion miLink9;

    public DaoProductoYHistorial(MiConexion miLink9) { this.miLink9 = miLink9; }

    public List<ProductoYHistorial> getAllDatas(){
        String sql = "SELECT producto.nombre, historial_de_precios.precio, historial_de_precios.fechadecambio FROM producto INNER JOIN historial_de_precios ON producto.id = historial_de_precios.producto_id_fk";
        List<ProductoYHistorial> list = new ArrayList<>();
        Connection con = miLink9.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String nombreProd = resultSet.getString("nombre");
                int precioProd = resultSet.getInt("precio");
                String fecha = resultSet.getString("fechadecambio");

                ProductoYHistorial productoYHistorial = new ProductoYHistorial(nombreProd, precioProd, fecha);
                list.add(productoYHistorial);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
