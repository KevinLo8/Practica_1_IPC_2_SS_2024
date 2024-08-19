package com.practica_1.Backend.Datos;

import java.time.LocalDate;

public class Data_Tarjeta {

    private String numero;
    private String tipo;
    private float limite;
    private String estado;
    private int numeroSolicitud;
    private LocalDate fechaAutorizacion;
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getLimite() {
        return limite;
    }
    public void setLimite(float limite) {
        this.limite = limite;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }
    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }
    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public static String convertirNumero(String numeroIn) throws NumberFormatException {

        int a = Integer.valueOf(numeroIn.substring(0, 4));
        int b = Integer.valueOf(numeroIn.substring(4, 8));
        int c = Integer.valueOf(numeroIn.substring(8, 12));
        int d = Integer.valueOf(numeroIn.substring(12));

        String numeroOut = String.valueOf(a) + " " + String.valueOf(b) + " " + String.valueOf(c) + " " + String.valueOf(d);

        return numeroOut;
    }

    public static String chequearNumero(String numeroIn) throws NumberFormatException {

        int a = Integer.valueOf(numeroIn.substring(0, 4));
        int b = Integer.valueOf(numeroIn.substring(5, 9));
        int c = Integer.valueOf(numeroIn.substring(10, 14));
        int d = Integer.valueOf(numeroIn.substring(15));

        String numeroOut = String.valueOf(a) + " " + String.valueOf(b) + " " + String.valueOf(c) + " " + String.valueOf(d);

        return numeroOut;
    }

    public static String revisarNumero(String numeroIn) throws NumberFormatException {
        
        for (int i = 0; i < numeroIn.length(); i++) {
            if (numeroIn.charAt(i) != 32) {
                if (numeroIn.charAt(i) < 48 || numeroIn.charAt(i) > 57) {
                    throw new NumberFormatException();
                }
            }
        }

        return numeroIn;
    }

}
