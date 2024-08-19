package com.practica_1.Backend.Conexión_DB;

import java.sql.*;
import java.time.LocalDate;

import com.practica_1.Backend.Datos.Data_Movimiento;
import com.practica_1.Backend.Datos.Data_Solicitud;
import com.practica_1.Backend.Datos.Data_Tarjeta;

public class Conexión_DB {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/CONTROL_BANCO";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection = null;

    public Conexión_DB(){
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

        int numeroSolicitud = siguienteNumero("solicitud");

        String insert = "INSERT INTO solicitud (número, fecha, tipo, nombre, salario, dirección, estado) "
                + "values('" + numeroSolicitud + "','" + data.getFecha() + "','" 
                + data.getTipo() + "','" + data.getNombre() + "','" 
                + data.getSalario() + "','" + data.getDireccion() + "','" + data.getEstado() + "');";

        insertData(insert);
                
    }

    private void insertData(String insert) {
        try {
            Statement statementInsert = connection.createStatement();
            int rowsAffected = statementInsert.executeUpdate(insert);
            System.out.println("Rows affected> " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al insertar a la DB");
            e.printStackTrace();
        }
    }

    private int siguienteNumero(String tabla){
        try {
            int numeroSolicitud = 0;

            String select = "SELECT * FROM " + tabla + ";";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                numeroSolicitud = resultSet.getInt("número");
            }

            numeroSolicitud++;
 
            return numeroSolicitud;
        } catch (SQLException e) {
            return 1;
        }
    }

    public Data_Solicitud pedirSolicitud(int numero) {

        try {
            
            String select = "SELECT * FROM solicitud where número = '" + numero + "';";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            Data_Solicitud data_Solicitud = new Data_Solicitud();

            if (resultSet.next()) {

                data_Solicitud.setNumero(resultSet.getInt("número"));
                data_Solicitud.setNombre(resultSet.getString("nombre"));
                data_Solicitud.setDireccion(resultSet.getString("dirección"));
                Float num = resultSet.getFloat("salario");
                data_Solicitud.setSalario(num.toString());
                data_Solicitud.setTipo(resultSet.getString("tipo"));
                data_Solicitud.setFecha(resultSet.getDate("fecha").toString());
                data_Solicitud.setEstado(resultSet.getString("estado"));

                return data_Solicitud;
            } else {
                return null;
            }

        } catch (SQLException e) {
            return null;
        }

    }

    public ResultSet pedirSolicitudes() {

        try {
            
            String select = "SELECT * FROM solicitud;";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            return resultSet;

        } catch (SQLException e) {
            return null;
        }

    }

    public void guardarTarjeta(Data_Tarjeta data) {

        String numero;

        do {

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

            numero = Data_Tarjeta.convertirNumero(numero);

        } while (coincidenciaTarjeta(numero));

        data.setNumero(numero);

        String insert = "INSERT INTO tarjeta (número, tipo, limite, estado, número_solicitud, fecha_cambio) "
                + "values('" + data.getNumero() + "','" + data.getTipo().toString() + "','" 
                + data.getLimite() + "','" + data.getEstado() + "','" 
                + String.valueOf(data.getNumeroSolicitud()) + "','" + data.getFechaCambio() + "')";

        insertData(insert);

    }

    public Boolean coincidenciaTarjeta(String numero){

        try {
            String select = "SELECT * FROM tarjeta";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            boolean coincidencia = false;

            while (resultSet.next()) {

                if (resultSet.getString("número").equals(numero)) {
                    coincidencia = true;
                }
                
            }    

            return coincidencia;
        } catch (SQLException e) {
            System.out.println("Error al leer la DB");
            e.printStackTrace();
            return false;
        }

    }

    public Boolean estaActivaTarjeta(String numero){

        Data_Tarjeta data_Tarjeta = pedirTarjeta(numero);

        boolean coincidencia;

        coincidencia = false;

        if (data_Tarjeta.getEstado().equals("Activada")) {
            coincidencia = true;
        }

        return coincidencia;
    }

    public void guardarMovimiento(Data_Movimiento data) {

        int numeroMovimiento = siguienteNumero("movimiento");

        String insert = "INSERT INTO movimiento (número, número_tarjeta, fecha, tipo, descripción, establecimiento, monto) "
                + "values('" + numeroMovimiento + "','" + data.getNumeroTarjeta() + "','" 
                + data.getFecha() + "','" + data.getTipo() + "','" + data.getDescripcion() + "','" 
                + data.getEstablecimiento() + "','" + data.getMonto() + "');";

        insertData(insert);

    }

    public Data_Tarjeta pedirTarjeta(String numero) {

        try {
            
            String select = "SELECT * FROM tarjeta where número = '" + numero + "';";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            Data_Tarjeta data_Tarjeta  = new Data_Tarjeta();

            if (resultSet.next()) {

                data_Tarjeta.setNumero(resultSet.getString("número"));
                data_Tarjeta.setTipo((resultSet.getString("tipo")));
                data_Tarjeta.setLimite(resultSet.getFloat("limite"));
                data_Tarjeta.setEstado(resultSet.getString("estado"));
                data_Tarjeta.setNumeroSolicitud(resultSet.getInt("número_solicitud"));
                data_Tarjeta.setFechaCambio(resultSet.getDate("fecha_cambio").toLocalDate());

                return data_Tarjeta;
            } else {
                return null;
            }

        } catch (SQLException e) {
            return null;
        }

    }

    public ResultSet pedirTarjetas() {

        try {
            
            String select = "SELECT * FROM tarjeta;";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            return resultSet;

        } catch (SQLException e) {
            return null;
        }

    }

    public ResultSet pedirMovimientos(String numero) {

        try {
            
            String select = "SELECT * FROM movimiento where número_tarjeta = '" + numero + "';";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            return resultSet;

        } catch (SQLException e) {
            return null;
        }

    } 

    public void cambiarEstadoCuenta(String numero){

        LocalDate fecha = LocalDate.now();
            
        String select = "UPDATE tarjeta SET estado = 'Cancelada', fecha_cambio = '" + fecha.toString() + "'' where número = '" + numero + "';";
        insertData(select);

    }

    public void cambiarEstadoSolicitud(String numero, String estado){

        LocalDate fecha = LocalDate.now();
            
        String select = "UPDATE solicitud SET estado = '" + estado + " " + fecha.toString() + "' where número = '" + numero + "';";
        insertData(select);

    }
}
