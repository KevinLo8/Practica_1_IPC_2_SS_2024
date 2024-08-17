package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Procesos.Proceso_Movimiento;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Movimiento extends JMenuItem {

    private Proceso_Movimiento proceso;
    
    public JMI_Movimiento(Frame_principal frame) {

        super("Ingreso de movimiento");

        proceso = new Proceso_Movimiento(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
