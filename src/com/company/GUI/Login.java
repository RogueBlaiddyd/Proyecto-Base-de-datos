package com.company.GUI;

import com.company.DAO.DaoUsuario;
import com.company.miconexion.MiConexion;
import com.company.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Login extends JFrame{
    private JButton ingresarAlMenuButton;
    private JTextField usuarioTextField;
    private JPanel panelLogin;
    private JPasswordField psswrdField;

    private MiConexion miLink;

    public Login(){
        //Setters del GUI
        super("Inicio de sesion");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panelLogin);

        //Componentes
        String ip = "localhost";
        String db = "minimarket";
        String user = "root";
        String password = "";

        //Conectores a base de datos
        try {
            miLink = new MiConexion(ip, user, password, db);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DaoUsuario daoUsuario = new DaoUsuario(miLink);

        //Botones
        ingresarAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Usuario> allusers = daoUsuario.getAllUsuarios();
                String userReal = null;
                String psswrdReal = null;

                for(Usuario u : allusers){
                    userReal = u.getUsername();
                    psswrdReal = u.getPassword();
                }

                String psswrdCompara = new String(psswrdField.getPassword());

                if(usuarioTextField.getText().equals(userReal) && psswrdCompara.equals(psswrdReal)){
                    JOptionPane.showMessageDialog(panelLogin, "Bienvenido, "+userReal);
                    dispose();
                    Menu menu = new Menu();
                }else{
                    JOptionPane.showMessageDialog(panelLogin, "Usuario o contraseña incorrectos");
                }
            }
        });



    }


}
