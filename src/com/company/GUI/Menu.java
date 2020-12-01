package com.company.GUI;

import com.company.DAO.DaoCategoria;
import com.company.DAO.DaoProducto;
import com.company.miconexion.MiConexion;
import com.company.model.Categoria;
import com.company.model.Producto;

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
    private JButton cambiarButton;

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
        DaoProducto daoProducto = new DaoProducto(miLink2);

        categoriaAgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCat = 0;
                String nombreCat = JOptionPane.showInputDialog("Ingrese el nombre de la categoria");

                daoCategoria.addCategoria(new Categoria(idCat, nombreCat));
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroDeCats = daoCategoria.numeroCat();
                if(numeroDeCats <= 0){
                    JOptionPane.showMessageDialog(panelMenu, "No hay ninguna categoria compadre, agregue una y regrese");
                }else{
                    int idNumero = 0;
                    String nombreproducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    String categoriaNombre = JOptionPane.showInputDialog("Ingrese el nombre de la categoria");
                    String precio = JOptionPane.showInputDialog("Ingrese el precio del producto");

                    int precioReal = Integer.parseInt(precio);

                    int numeroCatConcreta = daoCategoria.comprobarCat(categoriaNombre);

                    if(numeroCatConcreta == 0){
                        JOptionPane.showMessageDialog(panelMenu, "La categoria ingresada no existe lol");
                    }else if(numeroCatConcreta == 1){
                        int idCategoria = daoCategoria.obtenerIdConcreto(categoriaNombre);
                        daoProducto.addProducto(new Producto(idNumero, nombreproducto, idCategoria, precioReal));
                    }
                }
            }
        });

        cambiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = JOptionPane.showInputDialog("Ingrese el producto al que modificara el precio");
                String precioNuevo = JOptionPane.showInputDialog("Ingrese el nuevo precio");

                int idProducto = daoProducto.obtenerIdEspecifico(producto);
                int precioReal = Integer.parseInt(precioNuevo);

                daoProducto.updatePrecio(precioReal, idProducto);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cosoPaEliminar = JOptionPane.showInputDialog("¿Desea eliminar un producto o una categoria?");

                if(cosoPaEliminar.equals("producto")){
                    String nombreProducto = JOptionPane.showInputDialog("¿Que producto desea eliminar?");
                    int idProducto = daoProducto.obtenerIdEspecifico(nombreProducto);

                    daoProducto.deleteProducto(idProducto);
                }else if (cosoPaEliminar.equals("categoria")){
                    String nombreCategoria = JOptionPane.showInputDialog("¿Que categoria desea eliminar?");
                    int idCategoria = daoCategoria.obtenerIdConcreto(nombreCategoria);

                    int comprobadorExistenciaEnProducto = daoProducto.countIdCatEnProd(idCategoria);

                    if(comprobadorExistenciaEnProducto == 0){
                        daoCategoria.deleteCategoria(idCategoria);
                    }else if(comprobadorExistenciaEnProducto == 1){
                        JOptionPane.showMessageDialog(panelMenu, "La categoria esta asociada a un producto, por favor, eliminar el producto primero");
                    }
                }else{
                    JOptionPane.showMessageDialog(panelMenu, "A elegido una opcion invalida, intente de nuevo");
                }
            }
        });


    }


}
