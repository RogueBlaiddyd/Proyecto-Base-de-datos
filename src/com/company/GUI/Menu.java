package com.company.GUI;

import com.company.DAO.DaoCategoria;
import com.company.miconexion.MiConexion;
import com.company.model.Categoria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panelMenu;
    private JButton agregarButton;
    private JButton categoriaAgButton;
    private JButton eliminarButton;
    private JButton mirarButton;
    private JButton agregarCliButton;
    private JTable table1;
    private JButton checarButton;
    private JTable table2;

    private MiConexion miLink2;

    public Menu(){
        //Setters del GUI
        super("Menu de tienda");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        add(panelMenu);

        //Componentes
        String ip = "localhost";
        String db = "minimarket";
        String user = "root";
        String password = "";

        //Conectores a base de datos
        try {
            miLink2 = new MiConexion(ip, user, password, db);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DaoCategoria daoCategoria = new DaoCategoria(miLink2);

        categoriaAgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCat = 0;
                String nombreCat = JOptionPane.showInputDialog("Ingrese el nombre de la categoria");

                daoCategoria.addCategoria(new Categoria(idCat, nombreCat));
            }
        });


    }


}
