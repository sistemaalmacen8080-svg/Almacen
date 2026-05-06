package com.example.ALMACENMULTIPRO.model;

public class Producto {

    private String id_Producto;
    private String prodNombre;
    private String prodCategoria; // 🔥 CAMBIADO
    private String prodOperador;  // 🔥 CAMBIADO
    private int stock;

    public Producto() {
        this.stock = 0; // 🔥 stock inicia en 0
    }

    public String getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(String id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdCategoria() {
        return prodCategoria;
    }

    public void setProdCategoria(String prodCategoria) {
        this.prodCategoria = prodCategoria;
    }

    public String getProdOperador() {
        return prodOperador;
    }

    public void setProdOperador(String prodOperador) {
        this.prodOperador = prodOperador;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}