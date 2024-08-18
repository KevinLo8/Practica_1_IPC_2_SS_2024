package com.practica_1.Frontend.InternalFrame;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Backend.Listeners.FocusListenerCasillaTarjeta;
import com.practica_1.Frontend.Frame_principal;

public class IF_Cancelacion extends JInternalFrame {

    private Frame_principal frame;
    private JPanel pnl1, pnl2, pnl3, pnl4, pnl5, pnl6, pnl7;
    private JTextField txf1;
    private JLabel lbl1;
    private JLabel lblf1;

    
    public IF_Cancelacion(Frame_principal frame) {

        super("Cancelar tarjeta", false, true, false, false);

        this.frame = frame;

        initComponentes();
        
    }

    private void initComponentes(){

        //Se configura el InternalFrame
        setLayout(new GridLayout(5, 1, 0, 5));

        //Se inician los paneles a usar
        pnl1 = new JPanel();
        pnl2 = new JPanel();
        pnl3 = new JPanel();
        pnl4 = new JPanel();
        pnl5 = new JPanel();
        pnl6 = new JPanel();
        pnl7 = new JPanel(new FlowLayout());

        //Se inician los labels a utilizar
        lblf1 = new JLabel("Ingrese el número de tarjeta que quiere consultar");
        lbl1 = new JLabel(" ");

        //se crea el boton a utilizar
        JButton btn1 = new JButton("Revisar");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(300, 25));
        txf1.setHorizontalAlignment(JTextField.CENTER);

        //Se agregan los componentes del primer panel
        pnl1.add(lblf1, BorderLayout.NORTH);
        pnl1.add(txf1);
        pnl1.add(lbl1, BorderLayout.SOUTH);

        //Se agrega el boton a su panel
        pnl2.add(btn1);

        //Se agregan los listeners a los componentes que lo requieren
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarActionPerformer();
            }
            
        });
        txf1.addFocusListener(new FocusListenerCasillaTarjeta(txf1, lbl1));

    }

    /**
     * Se lee el TextField y se revisa si esta activa y 
     * si tiene saldo pendiente la tarjeta
     */
    private void btnCancelarActionPerformer(){
        try {
            if (lbl1.getText().equals(" ")) {
                Data_Tarjeta data_Tarjeta = frame.getConexion().pedirTarjeta(txf1.getText());
                if (data_Tarjeta.getEstado().equals("Activa")) {
                    ResultSet resultset = frame.getConexion().pedirMovimientos(txf1.getText());
                    if (!frame.getCalculador().tieneSaldoPendiente(resultset)) {
                        frame2();
                    } else {
                        lbl1.setText("Tarjeta con saldo pendiente, no se puede cancelar");
                    }    
                } else {
                    lbl1.setText("Tarjeta ingresada no esta activa");
                }
            }
        } catch (Exception e) {
            lbl1.setText("Error en la DB");
        }
    }

    public void hacerVisible() {

        //se vuelve visible el InternalFrame si ni lo es
        if (!isClosed()) {
            setVisible(true);
            frame1();
        }

    }
    
    private void frame1(){

        //Se cambia el tamaño del InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 200) / 2, 400, 200);

        //Se limipia el InternalFrame
        remove(pnl1);
        remove(pnl2);
        remove(pnl3);
        remove(pnl4);
        remove(pnl5);
        remove(pnl6);
        remove(pnl7);

        //Se agregan los componentes al InternalFrame
        add(pnl1);
        add(pnl2);        
    }

    private void frame2(){
        
        //Se cambia el tamaño del InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 600) / 2, 400, 600);

        //Se limipia el InternalFrame
        remove(pnl1);
        remove(pnl2);
        remove(pnl3);
        remove(pnl4);
        remove(pnl5);
        remove(pnl6);
        remove(pnl7);

        //Se agragan los nuevos paneles
        add(pnl3);
        add(pnl4);        
        add(pnl5);
        add(pnl6); 
        add(pnl7); 
        
        //Se piden los datos de la tarjeta
        Data_Tarjeta dataT = frame.getConexion().pedirTarjeta(txf1.getText());
        Data_Solicitud dataS = frame.getConexion().pedirSolicitud(dataT.getNumeroSolicitud());

        //Se crean las labels con los datos
        JLabel lbl2 = new JLabel("Datos de la tarjeta a cancelar");
        JLabel lbl3 = new JLabel("Número de tarjeta:  " + dataT.getNumero());
        JLabel lbl4 = new JLabel("Tipo de tarjeta:  " + dataT.getTipo());
        JLabel lbl5 = new JLabel("Limite de crédito:  " + dataT.getLimite());
        JLabel lbl6 = new JLabel("Nombre de titular:  " + dataS.getNombre());
        JLabel lbl7 = new JLabel("Dirección de titular:  " + dataS.getDireccion());
        JLabel lbl8 = new JLabel("Estado de la tarjeta:  " + dataT.getEstado());

        //Se crea los botones necesarios
        JButton btn2 = new JButton("Regresar");
        JButton btn3 = new JButton("Cancelar");

        //Se agregan las labels a los paneles
        pnl3.add(lbl2);
        pnl4.add(lbl3, BorderLayout.NORTH);
        pnl4.add(lbl4, BorderLayout.SOUTH);
        pnl5.add(lbl5, BorderLayout.NORTH);
        pnl5.add(lbl6, BorderLayout.SOUTH);
        pnl6.add(lbl7, BorderLayout.NORTH);
        pnl6.add(lbl8, BorderLayout.SOUTH);

        //se agregan los botones a su panel
        pnl7.add(btn2);
        pnl7.add(btn3);

        //Se agregan los liteners a los botones
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame1();
            }
            
        });
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getConexion().cambiarEstadoCuenta(txf1.getText());
            }
            
        });

    }

}
