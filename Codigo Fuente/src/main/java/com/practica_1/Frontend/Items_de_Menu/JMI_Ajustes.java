package com.practica_1.Frontend.Items_de_Menu;

import java.awt.event.*;

import javax.swing.*;

public class JMI_Ajustes extends JMenuItem {
    
    public JMI_Ajustes(JFrame frame) {
        super("Ajustes");
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDesktopPane desktop = new JDesktopPane();
                JInternalFrame frame = new JInternalFrame();
                frame.setVisible(true);
                desktop.add(frame);
                try {
                    frame.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {}
            }
            
        });
    }
    
}
