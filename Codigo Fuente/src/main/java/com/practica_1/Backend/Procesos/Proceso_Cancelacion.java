package com.practica_1.Backend.Procesos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Listeners.FocusListenerCasillaTarjeta;
import com.practica_1.Frontend.Frame_principal;

public class Proceso_Cancelacion {

    private Frame_principal frame;
    private JInternalFrame iFrame;
    private JTextField txf1;
    private JLabel lbl1;
    private JLabel lblf1;

    

    public Proceso_Cancelacion(Frame_principal frame) {
        this.frame = frame;

        //Se inicia el InternalFrame
        iFrame = new JInternalFrame("Consultar tarjeta", false, true, false, false);

        //Se configura el InternalFrame
        iFrame.setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 200) / 2, 400, 200);
        iFrame.setLayout(new GridLayout(2, 1, 0, 5));

        //Se agrega el InternalFrane al Desktop
        frame.getDesktop().add(iFrame);

        initComponentes();
        
    }

    private void initComponentes(){

        //Se inician los componentes del InternalFrame
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();

        lblf1 = new JLabel("Ingrese el número de tarjeta que quiere consultar (sin espacios)");

        lbl1 = new JLabel(" ");

        JButton btn1 = new JButton("Consultar");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(300, 25));
        txf1.setHorizontalAlignment(JTextField.CENTER);

        //Se agregan los componentes al InternalFrame
        iFrame.add(pnl1);
        iFrame.add(pnl2);

        //Se agregan los componentes en sus respectivos espacios
        pnl1.add(lblf1, BorderLayout.NORTH);
        pnl1.add(txf1);
        pnl1.add(lbl1, BorderLayout.SOUTH);

        pnl2.add(btn1);

        //Se agregan los listeners a los componentes que lo requieren
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnConsultarActionPerformer();
            }
            
        });
        txf1.addFocusListener(new FocusListenerCasillaTarjeta(txf1, lbl1));

    }

    private void btnConsultarActionPerformer(){
        
    }

    public void hacerVisible() {

        if (!iFrame.isClosed()) {
            iFrame.setVisible(true);
        }

    }

}
