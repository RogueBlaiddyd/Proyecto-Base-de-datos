package com.company.GUI;

import com.company.DAO.*;
import com.company.miconexion.MiConexion;
import com.company.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Menu extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panelMenu;
    private JButton agregarButton;
    private JButton categoriaAgButton;
    private JButton eliminarButton;
    private JButton mirarButton;
    private JButton agregarCliButton;
    private JTable productosTable;
    private JButton checarButton;
    private JTable preciosTable;
    private JButton cambiarButton;
    private JButton comenzarButton;
    private JButton pagarButton;
    private JButton crearButton;

    private MiConexion miLink2;
    private DefaultTableModel modeloTable;
    private DefaultTableModel modeloTable2;

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
        DaoProductoYCategorias daoProductoYCategorias = new DaoProductoYCategorias(miLink2);
        DaoProductoYHistorial daoProductoYHistorial = new DaoProductoYHistorial(miLink2);
        DaoCliente daoCliente = new DaoCliente(miLink2);
        DaoFactura daoFactura = new DaoFactura(miLink2);
        DaoDetalle daoDetalle = new DaoDetalle(miLink2);
        DaoValorTotal daoValorTotal = new DaoValorTotal(miLink2);

        //Creacion Modelo Tabla
        modeloTable = new DefaultTableModel();
        modeloTable.addColumn("NombreProducto");
        modeloTable.addColumn("Categoria");
        modeloTable.addColumn("Precio");
        productosTable.setModel(modeloTable);

        modeloTable2 = new DefaultTableModel();
        modeloTable2.addColumn("Nombre producto");
        modeloTable2.addColumn("Precio antiguo");
        modeloTable2.addColumn("Fecha Cambio");
        preciosTable.setModel(modeloTable2);

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

        mirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ProductoYCategorias> allDatas = daoProductoYCategorias.getAllData();

                modeloTable = new DefaultTableModel();
                modeloTable.addColumn("NombreProducto");
                modeloTable.addColumn("Categoria");
                modeloTable.addColumn("Precio");
                productosTable.setModel(modeloTable);

                for(ProductoYCategorias p : allDatas){
                    String[] valores = new String[]{p.getNombreProducto(), p.getNombreCategoria(), String.valueOf(p.getPrecio())};
                    modeloTable.addRow(valores);
                }
            }
        });

        checarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ProductoYHistorial> allDatas = daoProductoYHistorial.getAllDatas();

                modeloTable2 = new DefaultTableModel();
                modeloTable2.addColumn("Nombre producto");
                modeloTable2.addColumn("Precio antiguo");
                modeloTable2.addColumn("Fecha Cambio");
                preciosTable.setModel(modeloTable2);

                for(ProductoYHistorial p : allDatas){
                    String[] valores = new String[]{p.getNombreProducto(), String.valueOf(p.getPrecio()), p.getFecha()};
                    modeloTable2.addRow(valores);
                }
            }
        });

        agregarCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCli = 0;
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
                String rutCli = JOptionPane.showInputDialog("Ingrese el rut del cliente");
                int preferencial = 0;

                daoCliente.addCliente(new Cliente(idCli, nombreCliente, rutCli, preferencial));
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrecliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente al que dirigira la factura");
                int idFac = 0;
                int idCli = daoCliente.idEspecifico(nombrecliente);
                String fecha = JOptionPane.showInputDialog("Ingrese la fecha de emision");
                int pagado = 0;

                daoFactura.addFactura(new Factura(idFac, idCli, fecha, pagado));
            }
        });

        comenzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idDet = 0;
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente al que pertenece la factura");
                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto que llevara");
                String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de productos que llevara");

                int idcliente = daoCliente.idEspecifico(nombreCliente);
                int idFactura = daoFactura.idFactEspecifico(idcliente);
                int idProducto = daoProducto.obtenerIdEspecifico(nombreProducto);
                int cantidadReal = Integer.parseInt(cantidad);
                int precioProducto = daoProducto.precioEnEspecifico(nombreProducto);

                int precioReal = precioProducto*cantidadReal;
                daoDetalle.addDetalle(new Detalle(idDet, idFactura, idProducto, cantidadReal, precioReal));
            }
        });

        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del ciente relacionado a la factura");
                int idCliente = daoCliente.idEspecifico(nombreCliente);
                int idFactura = daoFactura.idFactEspecifico(idCliente);

                int total = daoDetalle.precioTotal(idFactura);
                daoValorTotal.procedimientoInsert(total, idFactura);

                daoFactura.procedimientoPagado(idFactura);

                daoValorTotal.totalConIva(total, idFactura);
            }
        });




    }


}
