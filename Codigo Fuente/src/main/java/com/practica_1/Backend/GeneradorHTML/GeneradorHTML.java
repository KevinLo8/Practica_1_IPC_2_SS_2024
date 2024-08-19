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
                Data_Solicitud dataS, ResultSet dataM, Float monto, Float interes){

        stringHTML = (stringHTML + "<FONT SIZE=5><p>" + "Estado de targeta No. " + String.valueOf(numero) + "</p></font>");
        stringHTML = (stringHTML + "<p>NÚMERO DE TARJETA:  " + dataT.getNumero() + "</p>");
        stringHTML = (stringHTML + "<p>TIPO DE TARJETA:  " + dataT.getTipo() + "</p>");
        stringHTML = (stringHTML + "<p>NOMBRE DE TITULAR:  " + dataS.getNombre() + "</p>");
        stringHTML = (stringHTML + "<p>DIRECCIÓN DE TITULAR:  " + dataS.getDireccion() + "</p>");

        stringHTML = (stringHTML + "<table><tr><th>FECHA</th>");
        stringHTML = (stringHTML + "<th>TIPO DE MOVIMIENTO</th>");
        stringHTML = (stringHTML + "<th>DESCRIPCIÓN</th>");
        stringHTML = (stringHTML + "<th>ESTABLECIMIENTO</th>");
        stringHTML = (stringHTML + "<th>MONTO</th></tr>");


        try {
            dataM.first();
            while (dataM.next()) {
                stringHTML = (stringHTML + "<tr><th>" + dataM.getDate("fecha").toString() + "</th>");
                stringHTML = (stringHTML + "<th>" + dataM.getString("tipo") + "</th>");
                stringHTML = (stringHTML + "<th>" + dataM.getString("descripción") + "</th>");
                stringHTML = (stringHTML + "<th>" + dataM.getString("establecimiento") + "</th>");
                stringHTML = (stringHTML + "<th>" + dataM.getString("monto") + "</th></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Float saldo = monto + interes;

        stringHTML = (stringHTML + "<p>MONTO TOTAL:  " + monto.toString() + "</p>");
        stringHTML = (stringHTML + "<p>INTERESES:  " + interes.toString() + "</p>");
        stringHTML = (stringHTML + "<p>SALDO TOTAL:  " + saldo.toString() + "</p>");

        stringHTML = (stringHTML + "</table>");

        return stringHTML;
    }

    public static String ReporteEstadosFinalHTML(String stringHTML){

        stringHTML = (stringHTML + "</body>");
        stringHTML = (stringHTML + "</html>");

        return stringHTML;
    }


}
