package com.practica_1.Backend.Datos;

public class Data_Solicitud {

    private int numero;
    private String nombre;
    private String direccion;
    private String salario;
    private String tipo;
    private String fecha;
    private String estado;
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Float retornarMinimo(String tipo) {
        float minimo = 0;

        switch (tipo) {
            case "NACIONAL":
                minimo = 5000;
                break;
            case "REGIONAL":
                minimo = 10000;
                break;
            case "INTERNACIONAL":
                minimo = 20000;
                break;
        }

        return minimo;
    }
}
