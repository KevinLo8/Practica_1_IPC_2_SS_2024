package com.practica_1.Backend.Datos;

public class Data_Movimiento {

    private String numeroTarjeta;
    private String fecha;
    private String tipo;
    private String descripcion;
    private String establecimiento;
    private String monto;
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstablecimiento() {
        return establecimiento;
    }
    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }
    public String getMonto() {
        return monto;
    }
    public void setMonto(String monto) {
        this.monto = monto;
    }
    
}
