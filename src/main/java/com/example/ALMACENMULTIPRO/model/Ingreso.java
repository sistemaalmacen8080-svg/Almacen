package com.example.ALMACENMULTIPRO.model;

import java.util.List;

public class Ingreso {

    private String id_Ingreso;
    private String ingProveedor;
    private String ingResponsable;
    private String ingFecha;
    private String ingHora;

    private List<DetalleIngreso> detalles;

    public Ingreso() {
    }

    public String getId_Ingreso() {
        return id_Ingreso;
    }

    public void setId_Ingreso(String id_Ingreso) {
        this.id_Ingreso = id_Ingreso;
    }

    public String getIngProveedor() {
        return ingProveedor;
    }

    public void setIngProveedor(String ingProveedor) {
        this.ingProveedor = ingProveedor;
    }

    public String getIngResponsable() {
        return ingResponsable;
    }

    public void setIngResponsable(String ingResponsable) {
        this.ingResponsable = ingResponsable;
    }

    public String getIngFecha() {
        return ingFecha;
    }

    public void setIngFecha(String ingFecha) {
        this.ingFecha = ingFecha;
    }

    public String getIngHora() {
        return ingHora;
    }

    public void setIngHora(String ingHora) {
        this.ingHora = ingHora;
    }

    public List<DetalleIngreso> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleIngreso> detalles) {
        this.detalles = detalles;
    }
}