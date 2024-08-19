package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;
import java.io.IOException;
import java.sql.*;

import javax.swing.*;

import com.practica_1.Backend.ConexiónArchivo.ConexionArchivo;
import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Exception.ArchivoExistenteException;
import com.practica_1.Backend.GeneradorHTML.GeneradorHTML;
import com.practica_1.Frontend.Frame_principal;

public class JMI_ReporteSolcitud extends JMenuItem {

    private Frame_principal frame;

    public JMI_ReporteSolcitud(Frame_principal frame) {
        
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

        ResultSet dataSolicitudes = frame.getConexion().pedirSolicitudes();

        String nombre = "Reporte_de_listado_de_solicitudes_No_";
        String path = frame.getConfig().getDirecciónSalida();
        nombre = ConexionArchivo.GenerarNombre(path, nombre);

        String dataHTML = GeneradorHTML.ReporteSolicitudInicioHTML();

        try {
            while (dataSolicitudes.next()) {
                    Data_Solicitud dataS = frame.getConexion().pedirSolicitud(dataSolicitudes.getInt("número"));

                    dataHTML = GeneradorHTML.ReporteSolicitudCuerpoHTML(dataHTML, dataS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataHTML = GeneradorHTML.ReporteSolicitudFinalHTML(dataHTML);

        try {
            ConexionArchivo.guardarArchivo(path, dataHTML, nombre);
        } catch (IOException | ArchivoExistenteException e) {
            e.printStackTrace();
        }

    }
}

