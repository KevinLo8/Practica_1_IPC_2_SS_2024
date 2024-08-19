package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.practica_1.Backend.ConexiónArchivo.ConexionArchivo;
import com.practica_1.Backend.Datos.*;
import com.practica_1.Backend.Exception.ArchivoExistenteException;
import com.practica_1.Backend.GeneradorHTML.GeneradorHTML;
import com.practica_1.Frontend.Frame_principal;

public class JMI_ReporteTarjetas extends JMenuItem {

    private Frame_principal frame;

    public JMI_ReporteTarjetas(Frame_principal frame) {
        
        super("Listado de tarjetas");
        this.frame = frame;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTarjetasActionPerformer();
            }
        });

    } 

    private void btnTarjetasActionPerformer() {

        ResultSet dataTarjetas = frame.getConexion().pedirTarjetas();

        String nombre = "Reporte_de_listado_de_tarjetas_No.";
        String path = frame.getConfig().getDirecciónSalida();
        nombre = ConexionArchivo.GenerarNombre(path, nombre);

        String dataHTML = GeneradorHTML.ReporteTarjetasInicioHTML();

        try {
            while (dataTarjetas.next()) {
                    Data_Tarjeta dataT = frame.getConexion().pedirTarjeta(dataTarjetas.getString("número"));
                    Data_Solicitud dataS = frame.getConexion().pedirSolicitud(dataT.getNumeroSolicitud());

                    dataHTML = GeneradorHTML.ReporteTarjetasCuerpoHTML(dataHTML, dataT, dataS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataHTML = GeneradorHTML.ReporteTarjetasFinalHTML(dataHTML);

        try {
            ConexionArchivo.guardarArchivo(path, dataHTML, nombre);
        } catch (IOException | ArchivoExistenteException e) {
            e.printStackTrace();
        }

    }
}
