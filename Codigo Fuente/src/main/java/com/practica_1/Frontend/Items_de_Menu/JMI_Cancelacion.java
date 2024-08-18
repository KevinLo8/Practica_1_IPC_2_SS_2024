package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Procesos.Proceso_Cancelacion;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Cancelacion extends JMenuItem {

    private Proceso_Cancelacion proceso;
    
    public JMI_Cancelacion(Frame_principal frame) {
        
        super("Consulta Tarjeta");

        proceso = new Proceso_Cancelacion(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
