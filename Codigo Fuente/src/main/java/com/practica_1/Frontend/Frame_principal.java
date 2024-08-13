package com.practica_1.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame_principal extends JFrame {

    //Secrea una constante con la dimension del la pantalla
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenuBar jMenuBar;
    private JMenu jM1, jM2;
    private JMenuItem itemA1, itemA2, itemA3, itemA4, itemA5, itemA6;

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
        jM2 = new JMenu("Reportes");

        jMenuBar.add(jM1);
        jMenuBar.add(jM2);

        itemA1 = new JMenuItem("Solicitud Nueva");
        itemA2 = new JMenuItem("Insertar Movimiento");
        itemA3 = new JMenuItem("Consultar Tarjeta");
        itemA4 = new JMenuItem("Autorizar Tarjeta");
        itemA5 = new JMenuItem("Cancelar Tarjeta");
        itemA6 = new JMenuItem("Salir");

        itemA6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

        jM1.add(itemA1);
        jM1.add(itemA2);
        jM1.add(itemA3);
        jM1.add(itemA4);
        jM1.add(itemA5);
        jM1.add(itemA6);

        setJMenuBar(jMenuBar);

    }

}
