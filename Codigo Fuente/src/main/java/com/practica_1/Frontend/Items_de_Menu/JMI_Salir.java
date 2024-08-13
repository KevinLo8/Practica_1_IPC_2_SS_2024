package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

public class JMI_Salir extends JMenuItem {
    
    public JMI_Salir() {
        super("Salir");
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
    }

}
