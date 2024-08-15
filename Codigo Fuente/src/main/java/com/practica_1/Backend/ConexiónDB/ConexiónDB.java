package com.practica_1.Backend.ConexiónDB;

import java.sql.*;

import com.practica_1.Backend.Datos.Data_Solicitud;

public class ConexiónDB {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/CONTROL_BANCO";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection;

        public ConexiónDB(){
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            connection.setSchema("CONTROL_BANCO");
            System.out.println("Esquema: " + connection.getSchema());
        } catch (SQLException ex) {
            System.out.println("error al conectar a la DB");
            ex.printStackTrace();
        }
    }

    public void guardarSolicitud(Data_Solicitud data){

    }
}
