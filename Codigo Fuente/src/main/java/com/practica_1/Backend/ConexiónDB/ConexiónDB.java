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

        int cantidadSolicitudes = 0

        try {
            String select = "SELECT * FROM solicitud";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            resultSet.last();

            cantidadSolicitudes = resultSet.getInt("numero");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        cantidadSolicitudes++;

        String insert = "INSERT INTO solicitud (numero, fecha, tipo, nombre, salario, direccion) "
                + "values('" + cantidadSolicitudes + "','" + data.getFecha() + "','" 
                + data.getTipo() + "','" + data.getNombre() + "','" 
                + data.getSalario() + "','" + data.getDireccion() + "')";

        try {

            Statement statementInsert = connection.createStatement();
            int rowsAffected = statementInsert.executeUpdate(insert);
            System.out.println("Rows affected> " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al insertar a la DB");
            e.printStackTrace();
        }
        
    }
}
