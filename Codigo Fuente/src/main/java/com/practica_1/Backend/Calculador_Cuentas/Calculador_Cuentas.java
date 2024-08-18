package com.practica_1.Backend.Calculador_Cuentas;

import java.sql.*;

public class Calculador_Cuentas {

    public float sacarCredito(float in) {
        
        double cantidad = in;

        cantidad = cantidad * 0.6;
        
        float out = (float) cantidad;

        return out;
    }

    public boolean tieneSaldoPendiente(ResultSet resultSet) throws SQLException {

        float saldo = 0;

        while (resultSet.next()) {
            if (resultSet.getString("tipo").equals("CARGO")) {
                saldo += resultSet.getFloat("Monto");
            } else {
                saldo -= resultSet.getFloat("Monto");
            }
        }

        if (saldo > 0) {
            return true;
        } else {
            return false;
        }

    }
}
