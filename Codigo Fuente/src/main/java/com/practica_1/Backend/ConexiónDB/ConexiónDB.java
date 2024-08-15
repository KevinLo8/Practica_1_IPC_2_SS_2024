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

        //int cantidadSolicitudes

        try {
            String select = "SELECT * FROM solicitud";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);


        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
            e.printStackTrace();
        }




        String insert = "INSERT INTO solicitud (numero, fecha, tipo, nombre, salario, direccion) "
                + "values('" + "//numero" + "','" + data.getFecha() + "','" 
                + data.getTipo() + "','" + data.getNombre() + "','" 
                + data.getSalario() + "','" + data.getDireccion() + "')";

    }
}
