package com.practica_1.Frontend.InternalFrame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.practica_1.Backend.ConexiónArchivo.ConexionArchivo;
import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Backend.Exception.ArchivoExistenteException;
import com.practica_1.Backend.GeneradorHTML.GeneradorHTML;
import com.practica_1.Backend.Listeners.FocusListenerCasillaTarjeta;
import com.practica_1.Frontend.Frame_principal;

public class IF_Consulta extends JInternalFrame {

    private Frame_principal frame;
    private JTextField txf1;
    private JLabel lbl1;
    private JLabel lblf1;

    public IF_Consulta(Frame_principal frame) {
        super("Consultar tarjeta", false, true, false, false);
        this.frame = frame;

        //Se configura el InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 200) / 2, 400, 200);
        setLayout(new GridLayout(2, 1, 0, 5));

        //Se agrega el InternalFrane al Desktop
        frame.getDesktop().add(this);

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
        add(pnl1);
        add(pnl2);

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

        try {
            Data_Tarjeta data_Tarjeta = frame.getConexion().pedirTarjeta(txf1.getText());

            if (data_Tarjeta != null) {
                Data_Solicitud data_Solicitud = frame.getConexion().pedirSolicitud(data_Tarjeta.getNumeroSolicitud());
    
                String stringHTML = GeneradorHTML.ConsultaHTML(data_Tarjeta, data_Solicitud);
                String pathSalida = frame.getConfig().getDirecciónSalida();
                String nombreArchivo = "Consulta sobre tarjeta No. " + data_Tarjeta.getNumero() + ".html";
        
                ConexionArchivo.guardarArchivo(pathSalida, stringHTML, nombreArchivo);
        
                lbl1.setText("Consulta generada con exito");                
            } else {
                if (lbl1.getText().equals(" ")) {
                    lbl1.setText("Número de tarjeta no existente");                
                }
            }    
        } catch (IOException e) {
            lbl1.setText("Dirección de salida no especificada");                
        } catch (ArchivoExistenteException e) {
            lbl1.setText("Consulta de tarjeta ya existente");                
        }
        
    }

    public void hacerVisible() {

        if (!isClosed()) {
            setVisible(true);
        }

    }

}
