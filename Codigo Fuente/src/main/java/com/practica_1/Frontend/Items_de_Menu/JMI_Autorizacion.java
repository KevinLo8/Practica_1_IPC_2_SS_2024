package com.practica_1.Frontend.Items_de_Menu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Frontend.Frame_principal;

public class JMI_Autorizacion extends JMenuItem {

    private Frame_principal frame;
    private JInternalFrame iFrame;
    private JTextField txf1;
    private JLabel lbl1;
    private JLabel lblf1;
    
    public JMI_Autorizacion(Frame_principal frame) {
        super("Autorizacion de solicitud");

        this.frame = frame;

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btnAutorizacionActionPerformer();  
                
            }

        });

    } 

    private void btnAutorizacionActionPerformer(){

        //Se inicia el InternalFrame
        iFrame = new JInternalFrame("Autorizacion de solicitud", false, true, false, false);

        //Se configura el InternalFrame
        iFrame.setVisible(true);
        iFrame.setBounds((frame.getDesktop().getWidth() - 400) / 2, (frame.getDesktop().getHeight() - 200) / 2, 400, 200);
        iFrame.setLayout(new GridLayout(2, 1, 0, 5));

        //Se agrega el InternalFrane al Desktop
        frame.getDesktop().add(iFrame);

        //Se inician los componentes del InternalFrame
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();

        lblf1 = new JLabel("Ingrese La solicitud que quiere autorizar");

        lbl1 = new JLabel(" ");

        JButton btn1 = new JButton("Autorizar solicitud");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(100, 25));

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
                btnAutorizarActionPerformer();
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

    }

    private void btnAutorizarActionPerformer(){

        try {
           
            int numero = Integer.valueOf(txf1.getText());
            if (numero > 0) {
                Data_Solicitud dataSolicitud = frame.getConexion().pedirSolicitud(numero);
                if (dataSolicitud != null) {
                
                    float credito = Float.parseFloat(dataSolicitud.getSalario());
                    float minimo = 0;

                    switch (dataSolicitud.getTipo()) {
                        case "NACIONAL":
                            minimo = 5000;
                            break;
                        case "REGIONAL":
                            minimo = 10000;
                            break;
                        case "INTERNACIONAL":
                            minimo = 20000;
                            break;
                    }

                    if (credito > minimo) {
                        Data_Tarjeta data = new Data_Tarjeta();

                        data.setNumeroSolicitud(numero);
                        data.setTipo(dataSolicitud.getTipo());
                        data.setLimite(minimo);
                        data.setEstado("Activada");

                        frame.getConexion().guardarTarjeta(data);

                        iFrame.dispose();

                    } else {
                        lbl1.setText("Salario insuficiente para la autorizacion"); 
                    }
                } else {
                    lbl1.setText("Numero de solicitud ingresado no existe");
                }
            }    
        } catch (NumberFormatException e) {
            lbl1.setText("Ingrese un numero de solicitud valido");
        }
    }

}
