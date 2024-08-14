package com.practica_1.Frontend.Items_de_Menu;

import java.text.DecimalFormat;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Configuraciones.Configuraciones;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Solicitud extends JMenuItem {

    private Configuraciones config;
    private Frame_principal frame;
    private JTextField txf1, txf2, txf3, txf4;
    private JLabel lbl1, lbl2, lbl3, lbl4;
    private JLabel lblf1, lblf2, lblf3, lblf4;
    
    public JMI_Solicitud(Frame_principal frame) {
        super("Solicitud Nueva");

        this.frame = frame;

        config = new Configuraciones();

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btnSolicitudActionPerformer();  
                
            }

        });

    } 

    private void btnSolicitudActionPerformer(){

        config.setArchivoEntrada(frame.getConfig().getArchivoEntrada());
        config.setDirecciónSalida(frame.getConfig().getDirecciónSalida());
        config.setVelocidadProcesamiento(frame.getConfig().getVelocidadProcesamiento());

        JInternalFrame iFrame = new JInternalFrame("Solicitud nueva", false, true, false, false);

        iFrame.setVisible(true);
        iFrame.setBounds((frame.getDesktop().getWidth() - 400) / 2, (frame.getDesktop().getHeight() - 450) / 2, 400, 450);
        iFrame.setLayout(new GridLayout(5, 1, 0, 5));

        frame.getDesktop().add(iFrame);

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

        iFrame.add(pnl1);
        iFrame.add(pnl2);
        iFrame.add(pnl3);
        iFrame.add(pnl4);
        iFrame.add(pnl5);

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

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrearActionPerformer();
            }
            
        });

        txf1.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                lbl1.setText(" ");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
            
        });
        txf2.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                lbl2.setText(" ");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
            
        });

        txf3.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                lbl3.setText(" ");
            }

            @Override
            public void focusLost(FocusEvent e) {

                try {

                    Float numero = Float.parseFloat(txf3.getText());
                    DecimalFormat df = new DecimalFormat("0.00");
                    df.setMaximumFractionDigits(2);
                    txf3.setText(df.format(numero));
    
                } catch (NumberFormatException ex) {
                    txf3.setText("0.00");
                    lbl3.setText("Ingrese un numero valido");
                }

            }
            
        });

        txf4.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                lbl4.setText(" ");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
            
        });

    }

    private void btnCrearActionPerformer(){
        int completo = 0;

        if (txf1.getText().length() < 100 && !txf1.getText().isEmpty()) {
            completo++;
        } else {
            lbl1.setText("Ingrese un nombre valido");
        }
        
        if (txf2.getText().length() < 150 && !txf2.getText().isEmpty()) {
            completo++;
        } else {
            lbl2.setText("Ingrese una dirección valida");
        }

        if (Float.parseFloat(txf3.getText()) > 0) {
            completo++;
        } else {
            lbl3.setText("Ingrese un numero mayor a 0");
        }

        if (txf4.getText() == "NACIONAL" || txf4.getText() == "REGIONAL" || txf4.getText() == "INTERNACIONAL") {
            completo++;
        } else {
            lbl4.setText("Ingrese un tipo de tarjeta valido");
        }

        if (completo == 4) {
            //se crea la solicitud
        }
    }

}
