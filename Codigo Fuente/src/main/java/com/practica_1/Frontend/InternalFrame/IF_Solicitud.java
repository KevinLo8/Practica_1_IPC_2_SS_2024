package com.practica_1.Frontend.InternalFrame;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Listeners.FocusListenerCasillaDinero;
import com.practica_1.Backend.Listeners.FocusListenerCasillaPalabra;
import com.practica_1.Frontend.Frame_principal;

public class IF_Solicitud extends JInternalFrame {

    private Frame_principal frame;
    private JTextField txf1, txf2, txf3, txf4;
    private JLabel lbl1, lbl2, lbl3, lbl4;
    private JLabel lblf1, lblf2, lblf3, lblf4;


    public IF_Solicitud(Frame_principal frame) {
        super("Solicitud nueva", false, true, false, false);
        this.frame = frame;

        //Se configura el InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 450) / 2, 400, 450);
        setLayout(new GridLayout(5, 1, 0, 5));

        //Se agrega el InternalFrane al Desktop
        frame.getDesktop().add(this);

        initComponentes();
        
    }

    private void initComponentes(){

        //Se configura el InternalFrame
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        //Se inician los componentes del InternalFrame
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();
        JPanel pnl3 = new JPanel();
        JPanel pnl4 = new JPanel();
        JPanel pnl5 = new JPanel();

        lblf1 = new JLabel("Ingrese el nombre de solicitante");
        lblf2 = new JLabel("Ingrese la direccion del solicitante");
        lblf3 = new JLabel("Ingrese el sueldo del solicitante");
        lblf4 = new JLabel("Ingrese el tipo de tarjeta que solicita");

        lbl1 = new JLabel(" ");
        lbl2 = new JLabel(" ");
        lbl3 = new JLabel(" ");
        lbl4 = new JLabel(" ");

        JButton btn1 = new JButton("Crear Solicitud");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(300, 25));
        txf2 = new JTextField();
        txf2.setPreferredSize(new Dimension(300, 25));
        txf3 = new JTextField("0.00");
        txf3.setPreferredSize(new Dimension(300, 25));
        txf4 = new JTextField();
        txf4.setPreferredSize(new Dimension(300, 25));

        //Se agregan los componentes al InternalFrame
        add(pnl1);
        add(pnl2);
        add(pnl3);
        add(pnl4);
        add(pnl5);

        //Se agregan los componentes en sus respectivos espacios
        pnl1.add(lblf1, BorderLayout.NORTH);
        pnl1.add(txf1);
        pnl1.add(lbl1, BorderLayout.SOUTH);

        pnl2.add(lblf2, BorderLayout.NORTH);
        pnl2.add(txf2);
        pnl2.add(lbl2, BorderLayout.SOUTH);

        pnl3.add(lblf3, BorderLayout.NORTH);
        pnl3.add(txf3);
        pnl3.add(lbl3, BorderLayout.SOUTH);

        pnl4.add(lblf4, BorderLayout.NORTH);
        pnl4.add(txf4);
        pnl4.add(lbl4, BorderLayout.SOUTH);

        pnl5.add(btn1);

        //Se agregan los listeners a los componentes que lo requieren
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrearActionPerformer();
            }
            
        });
        txf1.addFocusListener(new FocusListenerCasillaPalabra(lbl1));
        txf2.addFocusListener(new FocusListenerCasillaPalabra(lbl2));
        txf3.addFocusListener(new FocusListenerCasillaDinero(txf3, lbl3));
        txf4.addFocusListener(new FocusListenerCasillaPalabra(lbl4));

    }

    private void btnCrearActionPerformer(){

        Data_Solicitud data = new Data_Solicitud();
        int completo = 0;

        if (txf1.getText().length() < 100 && !txf1.getText().isEmpty()) {
            data.setNombre(txf1.getText());
            completo++;
        } else {
            lbl1.setText("Ingrese un nombre valido");
        }
        
        if (txf2.getText().length() < 150 && !txf2.getText().isEmpty()) {
            data.setDireccion(txf2.getText());
            completo++;
        } else {
            lbl2.setText("Ingrese una dirección valida");
        }

        if (Float.parseFloat(txf3.getText()) > 0) {
            data.setSalario(txf3.getText());
            completo++;
        } else {
            lbl3.setText("Ingrese un numero mayor a 0");
        }

        if (txf4.getText().equalsIgnoreCase("NACIONAL") || 
                txf4.getText().equalsIgnoreCase("REGIONAL") || 
                txf4.getText().equalsIgnoreCase("INTERNACIONAL")) {
            data.setTipo(txf4.getText().toUpperCase());
            completo++;
        } else {
            lbl4.setText("Ingrese un tipo de tarjeta valido");
        }

        if (completo == 4) {

            data.setEstado("Pendiente autorización");

            LocalDate fecha = LocalDate.now();
            data.setFecha(fecha.toString());

            frame.getConexion().guardarSolicitud(data);

            dispose();
        }
    }

    public void hacerVisible() {

        setVisible(true);
        txf1.setText("");
        txf2.setText("");
        txf3.setText("");
        txf4.setText("");

    }

}
