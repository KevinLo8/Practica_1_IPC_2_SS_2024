package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Configuraciones.Configuraciones;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Solicitud extends JMenuItem {

    private Configuraciones config;
    private Frame_principal frame;
    
    public JMI_Solicitud(Frame_principal frame) {
        super("Solicitud Nueva");

        this.frame = frame;

        config = new Configuraciones();
        config.setArchivoEntrada(frame.getConfig().getArchivoEntrada());
        config.setDirecciónSalida(frame.getConfig().getDirecciónSalida());
        config.setVelocidadProcesamiento(frame.getConfig().getVelocidadProcesamiento());

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

               btnAjustesActionPerformer(); 
                        
            }

        });

    } 

}
