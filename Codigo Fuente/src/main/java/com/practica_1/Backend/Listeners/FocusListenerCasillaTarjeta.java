package com.practica_1.Backend.Listeners;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Datos.Data_Tarjeta;

public class FocusListenerCasillaTarjeta implements FocusListener {

    private JTextField txf;
    private JLabel lbl;

    public FocusListenerCasillaTarjeta(JTextField txf, JLabel lbl) {
        this.txf = txf;
        this.lbl = lbl;
    }

    @Override
    public void focusGained(FocusEvent e) {
        lbl.setText(" ");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (txf.getText().length() > 0) {
            try {
                Data_Tarjeta.revisarNumero(txf.getText());
                if (txf.getText().length() == 16) {
                    String numero = Data_Tarjeta.convertirNumero(txf.getText());
                    txf.setText(numero);
                } if (txf.getText().length() == 19) {
                    String numero = Data_Tarjeta.chequearNumero(txf.getText());
                    txf.setText(numero);
                } else {
                    lbl.setText("Tamaño de número no valido");
                }
            } catch (NumberFormatException ex) {
                lbl.setText("Inserte un numero de tarjeta valido");
            }
        }
    }

}
