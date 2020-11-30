package com.company.DAO;

import com.company.miconexion.MiConexion;
import com.company.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoUsuario {
    private MiConexion miLink2;

    private Usuario users;

    public DaoUsuario(MiConexion miLink2) { this.miLink2 = miLink2; }

    public List<Usuario> getAllUsuarios(){
        String sql = "SELECT id, nombreusuario, contraseña FROM usuario";
        List<Usuario> list = new ArrayList<>();
        Connection con = miLink2.getCon();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombreUser = resultSet.getString("nombreusuario");
                String contraseña = resultSet.getString("contraseña");

                users = new Usuario(id, nombreUser, contraseña);
                list.add(users);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

}
