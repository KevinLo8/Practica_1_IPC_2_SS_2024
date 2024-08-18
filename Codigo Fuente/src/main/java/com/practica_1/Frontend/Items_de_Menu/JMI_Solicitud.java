package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Procesos.Proceso_Solicitud;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Solicitud extends JMenuItem {
    
    private Proceso_Solicitud proceso;

    public JMI_Solicitud(Frame_principal frame) {
        super("Solicitud Nueva");

        proceso = new Proceso_Solicitud(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();  
                
            }

        });

    } 

}
