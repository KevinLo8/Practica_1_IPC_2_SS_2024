package com.practica_1.Frontend.InternalFrame;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Backend.Listeners.FocusListenerCasillaPalabra;
import com.practica_1.Frontend.Frame_principal;

public class IF_Autorizacion extends JInternalFrame {

    private Frame_principal frame;
    private JTextField txf1;
    private JLabel lbl1;
    private JLabel lblf1;

    public IF_Autorizacion(Frame_principal frame) {
        super("Autorizacion de solicitud", false, true, false, false);
        this.frame = frame;

        //Se configura el InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 200) / 2, 400, 200);
        setLayout(new GridLayout(2, 1, 0, 5));

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

        lblf1 = new JLabel("Ingrese la solicitud que quiere autorizar");

        lbl1 = new JLabel(" ");

        JButton btn1 = new JButton("Autorizar solicitud");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(250, 25));
        txf1.setHorizontalAlignment(JTextField.CENTER);

        //Se agregan los componentes al InternalFrame
        add(pnl1);
        add(pnl2);

        //Se agregan los componentes en sus respectivos espacios
        pnl1.add(lblf1, BorderLayout.NORTH);
        pnl1.add(txf1, BorderLayout.CENTER);
        pnl1.add(lbl1, BorderLayout.SOUTH);

        pnl2.add(btn1);

        //Se agregan los listeners a los componentes que lo requieren
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnAutorizarActionPerformer();
            }
            
        });
        txf1.addFocusListener(new FocusListenerCasillaPalabra(lbl1));

    }

    private void btnAutorizarActionPerformer(){

        try {
            //Se revisa si se ingreso un número
            int numero = Integer.valueOf(txf1.getText());
            //Se revisa que el número ingresado se mayor a 0
            if (numero > 0) {
                Data_Solicitud dataSolicitud = frame.getConexion().pedirSolicitud(numero);
                //Se revisa que el número de solicitud ingresado exista
                if (dataSolicitud != null) {
                    //Se revisa que la solicitud no haya sido procesada
                    if (dataSolicitud.getEstado().equals("Pendiente autorización")) {
                        float sueldo = Float.parseFloat(dataSolicitud.getSalario());
                        float credito = frame.getCalculador().sacarCredito(sueldo);
                        float minimo = Data_Solicitud.retornarMinimo(dataSolicitud.getTipo());
                        //Se revisa si se puede aprovar la solicitud
                        if (credito > minimo) {
                            Data_Tarjeta data = new Data_Tarjeta();
    
                            data.setNumeroSolicitud(numero);
                            data.setTipo(dataSolicitud.getTipo());
                            data.setLimite(credito);
                            data.setEstado("Activada");
    
                            LocalDate fecha = LocalDate.now();
                            data.setFechaCambio(fecha);
    
                            frame.getConexion().guardarTarjeta(data);
                            frame.getConexion().cambiarEstadoSolicitud(txf1.getText(), "Aprobada");
                            
                            lbl1.setText("Solicitud autorizada con exito"); 
    
                        } else {
                            lbl1.setText("Solicitud rechazada por salario bajo requisito mínimo");
                            frame.getConexion().cambiarEstadoSolicitud(txf1.getText(), "Rechazada"); 
                        }    
                    } else {
                        lbl1.setText("Solicitud previamente procesada"); 
                    }
                } else {
                    lbl1.setText("Numero de solicitud ingresado no existe");
                }
            } else {
                lbl1.setText("Ingrese un número mayor a 0");
            }   
        } catch (NumberFormatException e) {
            lbl1.setText("Ingrese un numero de solicitud valido");
        }
    }

    public void hacerVisible() {

        setVisible(true);
        txf1.setText("");

    }

}
