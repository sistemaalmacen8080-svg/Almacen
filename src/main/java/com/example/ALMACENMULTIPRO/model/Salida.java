package com.example.ALMACENMULTIPRO.model;

import java.util.List;

public class Salida {

    private String id_Salida;
    private String salResponsable;
    private String salFecha;
    private String salHora;
    private String salProveedor;

    private List<DetalleSalida> detalles;

    public Salida() {
    }

    public String getId_Salida() {
        return id_Salida;
    }

    public void setId_Salida(String id_Salida) {
        this.id_Salida = id_Salida;
    }

    public String getSalResponsable() {
        return salResponsable;
    }

    public void setSalResponsable(String salResponsable) {
        this.salResponsable = salResponsable;
    }

    public String getSalFecha() {
        return salFecha;
    }

    public void setSalFecha(String salFecha) {
        this.salFecha = salFecha;
    }

    public String getSalHora() {
        return salHora;
    }

    public void setSalHora(String salHora) {
        this.salHora = salHora;
    }

    public List<DetalleSalida> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleSalida> detalles) {
        this.detalles = detalles;
    }

    public String getSalProveedor() {
        return salProveedor;
    }

    public void setSalProveedor(String salProveedor) {
        this.salProveedor = salProveedor;
    }
}