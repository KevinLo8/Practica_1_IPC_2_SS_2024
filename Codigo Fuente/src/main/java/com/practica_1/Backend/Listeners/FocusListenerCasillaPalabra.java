package com.practica_1.Backend.Listeners;

import java.awt.event.*;

import javax.swing.*;

public class FocusListenerCasillaPalabra implements FocusListener {

    private JLabel lbl;

    public FocusListenerCasillaPalabra(JLabel lbl) {
        this.lbl = lbl;
    }

    @Override
    public void focusGained(FocusEvent e) {
        lbl.setText(" ");
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
