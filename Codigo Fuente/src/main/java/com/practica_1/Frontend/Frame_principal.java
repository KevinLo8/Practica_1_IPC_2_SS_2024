package com.practica_1.Frontend;

import javax.swing.*;

import com.practica_1.Backend.Listeners.JMI_Ajustes;
import com.practica_1.Backend.Listeners.JMI_Salir;

import java.awt.*;

public class Frame_principal extends JFrame {

    //Secrea una constante con la dimension del la pantalla
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int size = 600;
    private JMenuBar jMenuBar;
    private JMenu jM1, jM2, jM3;
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
        setBounds(((int)dim.getWidth() - size) / 2, ((int)dim.getHeight() - size) / 2, size, size);
        setTitle("Registro de Trajetas");

        jMenuBar = new JMenuBar();
        jM1 = new JMenu("Archivo");
        jM2 = new JMenu("Acciones");
        jM3 = new JMenu("Reportes");

        jMenuBar.add(jM1);
        jMenuBar.add(jM2);
        jMenuBar.add(jM3);

        JMI_Ajustes itemA1 = new JMI_Ajustes(this);
        JMI_Salir itemA2 = new JMI_Salir();

        itemAc1 = new JMenuItem("Solicitud Nueva");
        itemAc2 = new JMenuItem("Insertar Movimiento");
        itemAc3 = new JMenuItem("Consultar Tarjeta");
        itemAc4 = new JMenuItem("Autorizar Tarjeta");
        itemAc5 = new JMenuItem("Cancelar Tarjeta");

        itemR1 = new JMenuItem("Solicitud Nueva");
        itemR2 = new JMenuItem("Insertar Movimiento");
        itemR3 = new JMenuItem("Consultar Tarjeta");


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
