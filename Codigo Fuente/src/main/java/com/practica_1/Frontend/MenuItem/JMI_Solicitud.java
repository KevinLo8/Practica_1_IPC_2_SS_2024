package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Frontend.Frame_principal;
import com.practica_1.Frontend.InternalFrame.IF_Solicitud;

public class JMI_Solicitud extends JMenuItem {
    
    private IF_Solicitud proceso;

    public JMI_Solicitud(Frame_principal frame) {
        super("Solicitud Nueva");

        proceso = new IF_Solicitud(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();  
                
            }

        });

    } 

}
