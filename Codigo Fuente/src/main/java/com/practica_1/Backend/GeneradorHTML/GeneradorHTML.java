package com.practica_1.Backend.GeneradorHTML;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;

public class GeneradorHTML {

    public static String ConsultaHTML(Data_Tarjeta dataT, Data_Solicitud dataS){

        String stringHTML = null;

        stringHTML = ("<html>");
        stringHTML = (stringHTML + "<head>");
        stringHTML = (stringHTML + "<title>" + "Consulta sobre targeta No. " + dataT.getNumero() + "</title>");
        stringHTML = (stringHTML + "</head>");
        stringHTML = (stringHTML + "<body>");

        stringHTML = (stringHTML + "<FONT SIZE=5><p>" + "Consulta sobre targeta No. " + dataT.getNumero() + "</p></font>");
        stringHTML = (stringHTML + "<p>Número de tarjeta:  " + dataT.getNumero() + "</p>");
        stringHTML = (stringHTML + "<p>Tipo de tarjeta:  " + dataT.getTipo() + "</p>");
        stringHTML = (stringHTML + "<p>Limite de crédito:  " + dataT.getLimite() + "</p>");
        stringHTML = (stringHTML + "<p>Nombre de titular:  " + dataS.getNombre() + "</p>");
        stringHTML = (stringHTML + "<p>Dirección de titular:  " + dataS.getDireccion() + "</p>");
        stringHTML = (stringHTML + "<p>Estado de la tarjeta:  " + dataT.getEstado() + "</p>");

        stringHTML = (stringHTML + "</body>");
        stringHTML = (stringHTML + "</html>");


        return stringHTML;
    }

    public static String ReporteEstadosInicioHTML(){

        String stringHTML = null;

        stringHTML = ("<html>");
        stringHTML = (stringHTML + "<head>");
        stringHTML = (stringHTML + "<title>" + "Estado de cuentas" + "</title>");
        stringHTML = (stringHTML + "</head>");
        stringHTML = (stringHTML + "<body>");

        return stringHTML;
    }

    public static String ReporteEstadosTarjetaHTML(String stringHTML, int numero, Data_Tarjeta dataT, 
                Data_Solicitud dataS, ResultSet resultSet, Float monto, Float interes){

        stringHTML = (stringHTML + "<FONT SIZE=5><p>" + "Estado de targeta No. " + String.valueOf(numero) + "</p></font>");
        stringHTML = (stringHTML + "<p>NÚMERO DE TARJETA:  " + dataT.getNumero() + "</p>");
        stringHTML = (stringHTML + "<p>TIPO DE TARJETA:  " + dataT.getTipo() + "</p>");
        stringHTML = (stringHTML + "<p>NOMBRE DE TITULAR:  " + dataS.getNombre() + "</p>");
        stringHTML = (stringHTML + "<p>DIRECCIÓN DE TITULAR:  " + dataS.getDireccion() + "</p>");

        stringHTML = (stringHTML + "<table border=\"1\"><tr><th>FECHA</th>");
        stringHTML = (stringHTML + "<th>TIPO DE MOVIMIENTO</th>");
        stringHTML = (stringHTML + "<th>DESCRIPCIÓN</th>");
        stringHTML = (stringHTML + "<th>ESTABLECIMIENTO</th>");
        stringHTML = (stringHTML + "<th>MONTO</th></tr>");


        try {
            while (resultSet.next()) {
                stringHTML = (stringHTML + "<tr><th>" + resultSet.getDate("fecha").toString() + "</th>");
                stringHTML = (stringHTML + "<th>" + resultSet.getString("tipo") + "</th>");
                stringHTML = (stringHTML + "<th>" + resultSet.getString("descripción") + "</th>");
                stringHTML = (stringHTML + "<th>" + resultSet.getString("establecimiento") + "</th>");
                stringHTML = (stringHTML + "<th>" + resultSet.getString("monto") + "</th></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Float saldo = monto + interes;

        stringHTML = (stringHTML + "</table>");

        stringHTML = (stringHTML + "<p>MONTO TOTAL:  " + monto.toString() + "</p>");
        stringHTML = (stringHTML + "<p>INTERESES:  " + interes.toString() + "</p>");
        stringHTML = (stringHTML + "<p>SALDO TOTAL:  " + saldo.toString() + "</p>");

        return stringHTML;
    }

    public static String ReporteEstadosFinalHTML(String stringHTML){

        stringHTML = (stringHTML + "</body>");
        stringHTML = (stringHTML + "</html>");

        return stringHTML;
    }

    public static String ReporteTarjetasInicioHTML(){

        String stringHTML = null;

        stringHTML = ("<html>");
        stringHTML = (stringHTML + "<head>");
        stringHTML = (stringHTML + "<title>Lista de tarjetas</title>");
        stringHTML = (stringHTML + "</head>");
        stringHTML = (stringHTML + "<body>");

        stringHTML = (stringHTML + "<FONT SIZE=5><p>Lista de tarjetas</p></font>");

        stringHTML = (stringHTML + "<table border=\"1\"><tr><th>NÚMERO DE TARJETA</th>");
        stringHTML = (stringHTML + "<th>TIPO</th>");
        stringHTML = (stringHTML + "<th>lÍMITE</th>");
        stringHTML = (stringHTML + "<th>NOMBRE</th>");
        stringHTML = (stringHTML + "<th>DIRECCIÓN</th>");
        stringHTML = (stringHTML + "<th>FECHA</th>");
        stringHTML = (stringHTML + "<th>ESTADO</th></tr>");

        return stringHTML;
    }

    public static String ReporteTarjetasCuerpoHTML(String stringHTML, Data_Tarjeta dataT, Data_Solicitud dataS){

        stringHTML = (stringHTML + "<tr><th>" + dataT.getNumero() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataT.getTipo() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataT.getLimite().toString() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getNombre() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getDireccion() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataT.getFechaCambio().toString() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataT.getEstado() + "</th></tr>");

        return stringHTML;
    }

    public static String ReporteTarjetasFinalHTML(String stringHTML){

        stringHTML = (stringHTML + "</table>");

        stringHTML = (stringHTML + "</body>");
        stringHTML = (stringHTML + "</html>");

        return stringHTML;
    }

    public static String ReporteSolicitudInicioHTML(){

        String stringHTML = null;

        stringHTML = ("<html>");
        stringHTML = (stringHTML + "<head>");
        stringHTML = (stringHTML + "<title>Lista de solicitudes</title>");
        stringHTML = (stringHTML + "</head>");
        stringHTML = (stringHTML + "<body>");

        stringHTML = (stringHTML + "<FONT SIZE=5><p>Lista de solicitudes</p></font>");

        stringHTML = (stringHTML + "<table border=\"1\"><tr><th>NÚMERO DE SOLICITUD</th>");
        stringHTML = (stringHTML + "<th>FECHA</th>");
        stringHTML = (stringHTML + "<th>TIPO</th>");
        stringHTML = (stringHTML + "<th>NOMBRE</th>");
        stringHTML = (stringHTML + "<th>SALARIO</th>");
        stringHTML = (stringHTML + "<th>DIRECCIÓN</th>");
        stringHTML = (stringHTML + "<th>ESTADO</th></tr>");

        return stringHTML;
    }

    public static String ReporteSolicitudCuerpoHTML(String stringHTML, Data_Solicitud dataS){

        stringHTML = (stringHTML + "<tr><th>" + dataS.getNumero() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getFecha().toString() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getTipo() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getNombre() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getSalario().toString() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getDireccion() + "</th>");
        stringHTML = (stringHTML + "<th>" + dataS.getEstado() + "</th></tr>");

        return stringHTML;
    }

    public static String ReporteSolicitudFinalHTML(String stringHTML){

        stringHTML = (stringHTML + "</table>");

        stringHTML = (stringHTML + "</body>");
        stringHTML = (stringHTML + "</html>");

        return stringHTML;
    }

}
