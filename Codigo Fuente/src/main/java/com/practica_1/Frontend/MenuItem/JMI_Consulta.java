package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Frontend.Frame_principal;
import com.practica_1.Frontend.InternalFrame.IF_Consulta;

public class JMI_Consulta extends JMenuItem {

    private IF_Consulta proceso;
    
    public JMI_Consulta(Frame_principal frame) {
        
        super("Consulta Tarjeta");

        proceso = new IF_Consulta(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
