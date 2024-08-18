package com.practica_1.Backend.Datos;

public class Data_Tarjeta {

    private String numero;
    private String tipo;
    private float limite;
    private String estado;
    private int numeroSolicitud;
    
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

    public static String convertirNumero(String numeroIn) throws NumberFormatException {

        int a = Integer.valueOf(numeroIn.substring(0, 4));
        int b = Integer.valueOf(numeroIn.substring(4, 8));
        int c = Integer.valueOf(numeroIn.substring(8, 12));
        int d = Integer.valueOf(numeroIn.substring(12, 17));

        String numeroOut = String.valueOf(a) + " " + String.valueOf(b) + " " + String.valueOf(c) + " " + String.valueOf(d);

        return numeroOut;
    }

    public static String chequearNumero(String numeroIn) throws NumberFormatException {

        int a = Integer.valueOf(numeroIn.substring(0, 4));
        int b = Integer.valueOf(numeroIn.substring(5, 9));
        int c = Integer.valueOf(numeroIn.substring(10, 14));
        int d = Integer.valueOf(numeroIn.substring(15, 19));

        String numeroOut = String.valueOf(a) + " " + String.valueOf(b) + " " + String.valueOf(c) + " " + String.valueOf(d);

        return numeroOut;
    }

}
