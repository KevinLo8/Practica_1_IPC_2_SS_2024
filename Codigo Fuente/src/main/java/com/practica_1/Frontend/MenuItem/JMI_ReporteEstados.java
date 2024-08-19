package com.practica_1.Frontend.MenuItem;

import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.practica_1.Backend.ConexiónArchivo.ConexionArchivo;
import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Backend.Exception.ArchivoExistenteException;
import com.practica_1.Backend.GeneradorHTML.GeneradorHTML;
import com.practica_1.Frontend.Frame_principal;

public class JMI_ReporteEstados extends JMenuItem {

    private Frame_principal frame;

    public JMI_ReporteEstados(Frame_principal frame) {
        
        super("Autorizacion de solicitud");
        this.frame = frame;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEstadosActionPerformer();
            }
        });

    } 

    private void btnEstadosActionPerformer() {

        ResultSet dataTarjetas = frame.getConexion().pedirTarjetas();

        String nombre = "Reporte_de_estado_de_cuentas_No.";
        String path = frame.getConfig().getDirecciónSalida();
        nombre = ConexionArchivo.GenerarNombre(path, nombre);

        String dataHTML = GeneradorHTML.ReporteEstadosInicioHTML();
        int numero = 1;

        try {
            while (dataTarjetas.next()) {
                if (dataTarjetas.getString("estado").equals("Activada")) {
                    Data_Tarjeta dataT = frame.getConexion().pedirTarjeta(dataTarjetas.getString("número"));
                    Data_Solicitud dataS = frame.getConexion().pedirSolicitud(dataT.getNumeroSolicitud());
                    ResultSet dataM = frame.getConexion().pedirMovimientos(dataT.getNumero());

                    float monto = frame.getCalculador().SaldoPendiente(dataM);
                    float intereses = frame.getCalculador().calculoIntereses(monto, dataT);

                    dataHTML = GeneradorHTML.ReporteEstadosTarjetaHTML(dataHTML, numero, dataT, dataS, dataM, monto, intereses);

                    numero++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataHTML = GeneradorHTML.ReporteEstadosFinalHTML(dataHTML);

        try {
            ConexionArchivo.guardarArchivo(path, dataHTML, nombre);
        } catch (IOException | ArchivoExistenteException e) {
            e.printStackTrace();
        }

    }
}
