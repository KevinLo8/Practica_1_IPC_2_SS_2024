package com.practica_1.Backend.Configuraciones;

public class Configuraciones {
    
    private String archivoEntrada;
    private int velocidadProcesamiento;
    private String direcciónSalida;
    
    public String getArchivoEntrada() {
        return archivoEntrada;
    }
    public void setArchivoEntrada(String archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
    }
    public int getVelocidadProcesamiento() {
        return velocidadProcesamiento;
    }
    public void setVelocidadProcesamiento(int velocidadProcesamiento) {
        this.velocidadProcesamiento = velocidadProcesamiento;
    }
    public String getDirecciónSalida() {
        return direcciónSalida;
    }
    public void setDirecciónSalida(String direcciónSalida) {
        this.direcciónSalida = direcciónSalida;
    }

}
