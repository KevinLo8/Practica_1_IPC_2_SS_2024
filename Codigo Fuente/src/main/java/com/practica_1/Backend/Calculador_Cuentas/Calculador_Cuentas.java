package com.practica_1.Backend.Calculador_Cuentas;

import java.sql.*;

import com.practica_1.Backend.Datos.Data_Tarjeta;

public class Calculador_Cuentas {

    public float sacarCredito(float in) {
        
        double cantidad = in;

        cantidad = cantidad * 0.6;
        
        float out = (float) cantidad;

        return out;
    }

    public Float SaldoPendiente(ResultSet resultSet) throws SQLException {

        float saldo = 0;

        while (resultSet.next()) {
            if (resultSet.getString("tipo").equals("CARGO")) {
                saldo += resultSet.getFloat("Monto");
            } else {
                saldo -= resultSet.getFloat("Monto");
            }
        }
        if (saldo > 0) {
            return saldo;
        } else {
            return (float) 0;
        }

    }

    public Float calculoIntereses(Float saldo, Data_Tarjeta data_Tarjeta) {

        Double intereses = 0.0;

        switch (data_Tarjeta.getTipo()) {
            case "NACIONAL":
                  intereses = saldo * 0.012;  
                break;
            case "REGIONAL":
                intereses = saldo * 0.023;  
                break;
            case "INTERNACIONAL":
                intereses = saldo * 0.0375;  
                break;
        }

        return intereses.floatValue();
    }
}
