package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Frontend.Frame_principal;
import com.practica_1.Frontend.InternalFrame.IF_Autorizacion;

public class JMI_Autorizacion extends JMenuItem {

    private IF_Autorizacion proceso;
    
    public JMI_Autorizacion(Frame_principal frame) {
        
        super("Autorizacion de solicitud");

        proceso = new IF_Autorizacion(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
