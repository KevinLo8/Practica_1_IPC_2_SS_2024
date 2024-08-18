package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Procesos.Proceso_Consulta;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Consulta extends JMenuItem {

    private Proceso_Consulta proceso;
    
    public JMI_Consulta(Frame_principal frame) {
        
        super("Autorizacion de solicitud");

        proceso = new Proceso_Consulta(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
