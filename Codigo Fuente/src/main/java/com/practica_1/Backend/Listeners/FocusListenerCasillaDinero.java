package com.practica_1.Backend.Listeners;

import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.*;

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

                        Float numero = Float.parseFloat(txf.getText());
                        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.GERMAN);
                        dfs.setDecimalSeparator('.');
                        DecimalFormat df = new DecimalFormat("#.00",dfs);
                        txf.setText(df.format(numero));
        
                    } catch (NumberFormatException ex) {
                        txf.setText("");
                        lbl.setText("Ingrese un número valido");
                    }      
                }

            }

}
