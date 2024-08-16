package com.practica_1.Backend.ConexiónDB;

import java.sql.*;

import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;
import com.practica_1.Backend.Exception.SolicitudAutorizadaException;
import com.practica_1.Frontend.Items_de_Menu.JMI_Autorizacion;

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

    public void guardarSolicitud(Data_Solicitud data) {

        int cantidadSolicitudes = 0;

        try {
            String select = "SELECT * FROM solicitud";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                cantidadSolicitudes = resultSet.getInt("numero");
            }

        } catch (SQLException e) {

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

    public Data_Solicitud pedirSolicitud(int numero) {

        try {
            String select = "SELECT * FROM solicitud where numero = " + numero;
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            Data_Solicitud data_Solicitud = new Data_Solicitud();

            if (resultSet.next()) {

                data_Solicitud.setNombre(resultSet.getString("nombre"));
                data_Solicitud.setDireccion(resultSet.getString("direccion"));
                Float num = resultSet.getFloat("salario");
                data_Solicitud.setSalario(num.toString());
                data_Solicitud.setTipo(resultSet.getString("tipo"));
                data_Solicitud.setFecha(resultSet.getDate("fecha").toString());

                return data_Solicitud;
            } else {
                return null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

    public void guardarTarjeta(Data_Tarjeta data, JMI_Autorizacion jmi_Autorizacion) throws SolicitudAutorizadaException {

        try {
            String select = "SELECT * FROM tarjeta where tipo = '" + data.getTipo() + "';";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            boolean coincidencia;
            String numero;

            do {

                coincidencia = false;

                numero = null;
                switch (data.getTipo()) {
                    case "NACIONAL":
                        numero = "42563102654";
                        break;
                    case "REGIONAL":
                        numero = "42563102656";
                        break;
                    case "INTERNACIONAL":
                        numero = "42563102658";
                        break;
                }

                for (int i = 0; i < 5; i++) {
                    int num = (int)Math.floor(Math.random() * 10);

                    numero = numero + String.valueOf(num);
                }

                while (resultSet.next()) {

                    if (resultSet.getString("numero").equals(numero)) {
                        coincidencia = true;
                    }
                    
                }    

            } while (coincidencia);

            data.setNumero(numero);

        } catch (SQLException e) {
            System.out.println("Error al insertar a la DB");
        e.printStackTrace();
        }

        String insert = "INSERT INTO tarjeta (numero, tipo, limite, estado, numero_solicitud) "
                + "values('" + data.getNumero() + "','" + data.getTipo().toString() + "','" 
                + data.getLimite() + "','" + data.getEstado() + "','" 
                + String.valueOf(data.getNumeroSolicitud()) + "')";

        try {

            Statement statementInsert = connection.createStatement();
            int rowsAffected = statementInsert.executeUpdate(insert);
            System.out.println("Rows affected> " + rowsAffected);

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SolicitudAutorizadaException();
        } catch (SQLException e) {
            System.out.println("Error al insertar a la DB");
            e.printStackTrace();
        }

    }

}
