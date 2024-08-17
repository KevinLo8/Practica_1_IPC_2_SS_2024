package com.practica_1.Frontend;

import javax.swing.*;

import com.practica_1.Backend.ConexiónDB.ConexiónDB;
import com.practica_1.Backend.Datos.Data_Config;
import com.practica_1.Frontend.Items_de_Menu.JMI_Ajustes;
import com.practica_1.Frontend.Items_de_Menu.JMI_Autorizacion;
import com.practica_1.Frontend.Items_de_Menu.JMI_Movimiento;
import com.practica_1.Frontend.Items_de_Menu.JMI_Salir;
import com.practica_1.Frontend.Items_de_Menu.JMI_Solicitud;

import java.awt.*;

public class Frame_principal extends JFrame {

    //Se crea una constante con la dimension del la pantalla
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int size = 700;

    //Se crea el panel de escritorio
    private JDesktopPane desktop;

    //Se crea una clase donde se guardaran las configuraciones
    private Data_Config config;

    //Se conecta crea la coneccion con la DB
    private ConexiónDB conexion;

    /**
     * Se crea el constructor del frame
     */
    public Frame_principal(){

        //Se declara las configuraciones
        config = new Data_Config();

        //Se declara la DB
        conexion = new ConexiónDB();

        initComponentes();
    }

    /**
     * Se inician los componentes del frame
     */
    private void initComponentes(){

        //Se configura el frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(((int)dim.getWidth() - size) / 2, ((int)dim.getHeight() - size) / 2, size, size);
        setTitle("Registro de Trajetas");

        //Se inicia el DesktopPane
        desktop = new JDesktopPane();
        add(desktop, BorderLayout.CENTER);

        //Se inicializa la barra de menú y sus componentes
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jM1 = new JMenu("Archivo");
        JMenu jM2 = new JMenu("Acciones");
        JMenu jM3 = new JMenu("Reportes");

        jMenuBar.add(jM1);
        jMenuBar.add(jM2);
        jMenuBar.add(jM3);

        JMI_Ajustes itemA1 = new JMI_Ajustes(this);
        JMI_Salir itemA2 = new JMI_Salir();

        JMI_Solicitud itemAc1 = new JMI_Solicitud(this);
        JMI_Movimiento itemAc2 = new JMI_Movimiento(this);
        JMenuItem itemAc3 = new JMenuItem("Consultar Tarjeta");
        JMI_Autorizacion itemAc4 = new JMI_Autorizacion(this);
        JMenuItem itemAc5 = new JMenuItem("Cancelar Tarjeta");

        JMenuItem itemR1 = new JMenuItem("Solicitud Nueva");
        JMenuItem itemR2 = new JMenuItem("Insertar Movimiento");
        JMenuItem itemR3 = new JMenuItem("Consultar Tarjeta");

        //Se arma la barra de menú
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

        //Se agrega la barra de menú al frame
        setJMenuBar(jMenuBar);

    }

    //Se declaran los getters necesarios
    public JDesktopPane getDesktop() {
        return desktop;
    }

    public Data_Config getConfig() {
        return config;
    }

    public ConexiónDB getConexion() {
        return conexion;
    }

}
