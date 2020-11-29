package com.company;

import javax.swing.*;

public class Login extends JFrame{
    private JButton ingresarAlMenuButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panelLogin;

    public Login(){
        super("Inicio de sesion");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panelLogin);
    }


}
