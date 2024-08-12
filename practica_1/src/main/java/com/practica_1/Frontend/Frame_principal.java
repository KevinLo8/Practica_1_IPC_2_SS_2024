package com.practica_1.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame_principal extends JFrame {

    //Secrea una constante con la dimension del la pantalla
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenuBar jMenuBar;
    private JMenu jM1, jM2, jM3;
    private JMenuItem itemA1, itemA2;
    private JMenuItem itemAc1, itemAc2, itemAc3, itemAc4, itemAc5;
    private JMenuItem itemR1, itemR2, itemR3;

    /**
     * Se crea el constructor del frame
     */
    public Frame_principal(){
        initComponentes();
    }

    /**
     * Se inician los componentes del frame
     */
    private void initComponentes(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(((int)dim.getWidth() - 500) / 2, ((int)dim.getHeight() - 500) / 2, 500, 500);
        setTitle("Registro de Trajetas");

        jMenuBar = new JMenuBar();
        jM1 = new JMenu("Archivo");
        jM2 = new JMenu("Acciones");
        jM3 = new JMenu("Reportes");

        jMenuBar.add(jM1);
        jMenuBar.add(jM2);
        jMenuBar.add(jM3);

        itemA1 = new JMenuItem("Ajustes");
        itemA2 = new JMenuItem("Salir");

        itemAc1 = new JMenuItem("Solicitud Nueva");
        itemAc1.setEnabled(false);
        itemAc2 = new JMenuItem("Insertar Movimiento");
        itemAc2.setEnabled(false);
        itemAc3 = new JMenuItem("Consultar Tarjeta");
        itemAc3.setEnabled(false);
        itemAc4 = new JMenuItem("Autorizar Tarjeta");
        itemAc4.setEnabled(false);
        itemAc5 = new JMenuItem("Cancelar Tarjeta");
        itemAc5.setEnabled(false);

        itemR1 = new JMenuItem("Estado de Cuenta");
        itemR1.setEnabled(false);
        itemR2 = new JMenuItem("Lista de Tarjetas");
        itemR2.setEnabled(false);
        itemR3 = new JMenuItem("Lista de Solicitudes");
        itemR3.setEnabled(false);


        itemA2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

        jM1.add(itemA1);
        jM1.add(itemA2);

        jM2.add(itemAc1);
        jM2.add(itemAc2);
        jM2.add(itemAc3);
        jM2.add(itemAc4);
        jM2.add(itemAc5);

        jM3.add(itemR1);
        jM3.add(itemR2);
        jM3.add(itemR3);

        setJMenuBar(jMenuBar);

    }
}
