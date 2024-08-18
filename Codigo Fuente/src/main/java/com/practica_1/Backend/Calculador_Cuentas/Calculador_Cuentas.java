package com.practica_1.Backend.Calculador_Cuentas;

public class Calculador_Cuentas {

    public float sacarCredito(float in) {
        
        double cantidad = in;

        cantidad = cantidad * 0.6;
        
        float out = (float) cantidad;

        return out;
    }

}
