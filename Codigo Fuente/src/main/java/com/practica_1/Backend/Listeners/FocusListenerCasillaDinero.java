package com.practica_1.Backend.Listeners;

import java.awt.event.*;

import javax.swing.*;

import com.practica_1.Backend.Calculador_Cuentas.Calculador_Cuentas;

public class FocusListenerCasillaDinero implements FocusListener {

    private JTextField txf;
    private JLabel lbl;

    public FocusListenerCasillaDinero(JTextField txf, JLabel lbl) {
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

                        Float numero = Calculador_Cuentas.acortarFloat(Float.parseFloat(txf.getText()));
                        txf.setText(numero.toString());
        
                    } catch (NumberFormatException ex) {
                        txf.setText("");
                        lbl.setText("Ingrese un número valido");
                    }      
                }

            }

}
