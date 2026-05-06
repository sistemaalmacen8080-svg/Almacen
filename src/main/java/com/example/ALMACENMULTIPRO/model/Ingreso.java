package com.example.ALMACENMULTIPRO.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Ingreso {

    private String id_Ingreso;
    private String ingProveedor;
    private String ingResponsable;
    private LocalDate ingFecha;
    private LocalTime ingHora;

    private List<DetalleIngreso> detalles;

    // getters y setters
    public String getId_Ingreso() { return id_Ingreso; }
    public void setId_Ingreso(String id_Ingreso) { this.id_Ingreso = id_Ingreso; }

    public String getIngProveedor() { return ingProveedor; }
    public void setIngProveedor(String ingProveedor) { this.ingProveedor = ingProveedor; }

    public String getIngResponsable() { return ingResponsable; }
    public void setIngResponsable(String ingResponsable) { this.ingResponsable = ingResponsable; }

    public LocalDate getIngFecha() { return ingFecha; }
    public void setIngFecha(LocalDate ingFecha) { this.ingFecha = ingFecha; }

    public LocalTime getIngHora() { return ingHora; }
    public void setIngHora(LocalTime ingHora) { this.ingHora = ingHora; }

    public List<DetalleIngreso> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleIngreso> detalles) { this.detalles = detalles; }
}