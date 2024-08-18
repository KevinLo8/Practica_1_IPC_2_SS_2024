package com.practica_1.Backend.GeneradorHTML;

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

        return stringHTML;
    }
}
