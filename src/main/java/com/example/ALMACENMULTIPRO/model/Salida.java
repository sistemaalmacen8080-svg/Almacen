package com.example.ALMACENMULTIPRO.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Salida {

    private String id_Salida;
    private String salProveedor;
    private String salResponsable;
    private LocalDate salFecha;
    private LocalTime salHora;

    private List<DetalleSalida> detalles;

    public String getId_Salida() { return id_Salida; }
    public void setId_Salida(String id_Salida) { this.id_Salida = id_Salida; }

    public String getSalProveedor() { return salProveedor; }
    public void setSalProveedor(String salProveedor) { this.salProveedor = salProveedor; }

    public String getSalResponsable() { return salResponsable; }
    public void setSalResponsable(String salResponsable) { this.salResponsable = salResponsable; }

    public LocalDate getSalFecha() { return salFecha; }
    public void setSalFecha(LocalDate salFecha) { this.salFecha = salFecha; }

    public LocalTime getSalHora() { return salHora; }
    public void setSalHora(LocalTime salHora) { this.salHora = salHora; }

    public List<DetalleSalida> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleSalida> detalles) { this.detalles = detalles; }
}