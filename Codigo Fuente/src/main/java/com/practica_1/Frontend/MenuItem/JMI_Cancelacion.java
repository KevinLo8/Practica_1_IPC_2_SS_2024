package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Frontend.Frame_principal;
import com.practica_1.Frontend.InternalFrame.IF_Cancelacion;

public class JMI_Cancelacion extends JMenuItem {

    private IF_Cancelacion frameCancelacion;
    
    public JMI_Cancelacion(Frame_principal frame) {
        
        super("Cancelar Tarjeta");

        frameCancelacion = new IF_Cancelacion(frame);  

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.getDesktop().add(frameCancelacion);
                frameCancelacion.hacerVisible();

            }

        });

    } 

}
