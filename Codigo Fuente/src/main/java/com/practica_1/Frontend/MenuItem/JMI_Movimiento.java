package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Frontend.Frame_principal;
import com.practica_1.Frontend.InternalFrame.IF_Movimiento;

public class JMI_Movimiento extends JMenuItem {

    private IF_Movimiento proceso;
    
    public JMI_Movimiento(Frame_principal frame) {

        super("Ingreso de movimiento");

        proceso = new IF_Movimiento(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                proceso.hacerVisible();

            }

        });

    } 

}
