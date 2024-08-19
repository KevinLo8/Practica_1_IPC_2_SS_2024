package com.practica_1.Frontend.InternalFrame;

import java.time.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Movimiento;
import com.practica_1.Backend.Listeners.*;
import com.practica_1.Frontend.Frame_principal;

public class IF_Movimiento extends JInternalFrame {

    private Frame_principal frame;
    private JTextField txf1, txf2, txf3, txf4, txf5, txf6;
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
    private JLabel lblf1, lblf2, lblf3, lblf4, lblf5, lblf6;

    

    public IF_Movimiento(Frame_principal frame) {
        super("Ingreso de movimiento", false, true, false, false);
        this.frame = frame;

        //Se configura el InternalFrame
        setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 600) / 2, 400, 600);
        setLayout(new GridLayout(7, 1, 0, 5));

        //Se agrega el InternalFrane al Desktop
        frame.getDesktop().add(this);

        initComponentes();
        
    }

    private void initComponentes(){

        //Se inician los componentes del InternalFrame
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();
        JPanel pnl3 = new JPanel();
        JPanel pnl4 = new JPanel();
        JPanel pnl5 = new JPanel();
        JPanel pnl6 = new JPanel();
        JPanel pnl7 = new JPanel();

        lblf1 = new JLabel("Ingrese el número de tarjeta a utilizar");
        lblf2 = new JLabel("Ingrese la fecha de la operación (dd/MM/yyyy)");
        lblf3 = new JLabel("Ingrese el tipo de movimiento");
        lblf4 = new JLabel("Ingrese la descripción del movimiento");
        lblf5 = new JLabel("Ingrese el codigo del establecimiento");
        lblf6 = new JLabel("Ingrese el monto de la operación");

        lbl1 = new JLabel(" ");
        lbl2 = new JLabel(" ");
        lbl3 = new JLabel(" ");
        lbl4 = new JLabel(" ");
        lbl5 = new JLabel(" ");
        lbl6 = new JLabel(" ");

        JButton btn1 = new JButton("Ingresar movimiento");

        txf1 = new JTextField();
        txf1.setPreferredSize(new Dimension(200, 25));
        txf1.setHorizontalAlignment(JTextField.CENTER);
        txf2 = new JTextField();
        txf2.setPreferredSize(new Dimension(200, 25));
        txf2.setHorizontalAlignment(JTextField.CENTER);
        txf3 = new JTextField();
        txf3.setPreferredSize(new Dimension(200, 25));
        txf3.setHorizontalAlignment(JTextField.CENTER);
        txf4 = new JTextField();
        txf4.setPreferredSize(new Dimension(200, 25));
        txf4.setHorizontalAlignment(JTextField.CENTER);
        txf5 = new JTextField();
        txf5.setPreferredSize(new Dimension(200, 25));
        txf5.setHorizontalAlignment(JTextField.CENTER);
        txf6 = new JTextField();
        txf6.setPreferredSize(new Dimension(200, 25));
        txf6.setHorizontalAlignment(JTextField.CENTER);

        //Se agregan los componentes al InternalFrame
        add(pnl1);
        add(pnl2);
        add(pnl3);
        add(pnl4);
        add(pnl5);
        add(pnl6);
        add(pnl7);

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

        pnl5.add(lblf5, BorderLayout.NORTH);
        pnl5.add(txf5);
        pnl5.add(lbl5, BorderLayout.SOUTH);

        pnl6.add(lblf6, BorderLayout.NORTH);
        pnl6.add(txf6);
        pnl6.add(lbl6, BorderLayout.SOUTH);

        pnl7.add(btn1);

        //Se agregan los listeners a los componentes que lo requieren
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresarActionPerformer();
            }
            
        });
        txf1.addFocusListener(new FocusListenerCasillaTarjeta(txf1, lbl1));
        txf2.addFocusListener(new FocusListenerCasillaPalabra(lbl2));
        txf3.addFocusListener(new FocusListenerCasillaPalabra(lbl3));
        txf4.addFocusListener(new FocusListenerCasillaPalabra(lbl4));
        txf5.addFocusListener(new FocusListenerCasillaPalabra(lbl5));
        txf6.addFocusListener(new FocusListenerCasillaDinero(txf6, lbl6));

    }

    private void btnIngresarActionPerformer(){

        Data_Movimiento data = new Data_Movimiento();
        int completo = 0;

        if (frame.getConexion().coincidenciaTarjeta(txf1.getText())) {
            if (frame.getConexion().estaActivaTarjeta(txf1.getText())) {
                data.setNumeroTarjeta(txf1.getText());
                completo++;    
            } else {
                lbl1.setText("Tarjeta ingresada esta cancelada");
            }
        } else {
            lbl1.setText("Número de tarjeta ingresado no valido");
        }

        try {
            int dia = Integer.valueOf(txf2.getText().substring(0, 2));
            int mes = Integer.valueOf(txf2.getText().substring(3, 5));
            int año = Integer.valueOf(txf2.getText().substring(6, 10));
            LocalDate date = LocalDate.of(año, mes, dia);

            data.setFecha(date.toString());
            completo++;
        } catch (NumberFormatException ex) {
            lbl2.setText("Inserte una fecha valida");
        } catch (DateTimeException ex) {
            lbl2.setText("Fecha insertada no valida");
        }   

        if (txf3.getText().equalsIgnoreCase("CARGO") || txf3.getText().equalsIgnoreCase("ABONO")) {
            
            data.setTipo(txf3.getText().toUpperCase());
            completo++;
            
        } else {
            lbl3.setText("Inserte un tipo de operación valido");
        }

        if (txf4.getText().length() < 201) {
            
            data.setDescripcion(txf4.getText());
            completo++;

        } else {
            lbl4.setText("Descripcion insertada muy larga");
        }

        if (txf5.getText().length() == 7) {
            
            data.setEstablecimiento(txf5.getText());
            completo++;

        } else {
            lbl5.setText("Codigo de establecimiento no valido");
        }

        if (Float.parseFloat(txf6.getText()) > 0) {
            data.setMonto(txf6.getText());
            completo++;
        } else {
            lbl6.setText("Ingrese un numero mayor a 0");
        }

        if (completo == 6) {

            frame.getConexion().guardarMovimiento(data);

            dispose();

        }

    }

    public void hacerVisible() {

        if (!isVisible()) {
            setVisible(true);
        }

    }

}
