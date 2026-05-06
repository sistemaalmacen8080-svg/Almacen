package com.example.ALMACENMULTIPRO.model;

public class Categoria {

    private String Id_Categoria;
    private String catNombre;

    public Categoria() {
    }

    public Categoria(String id_Categoria, String catNombre) {
        Id_Categoria = id_Categoria;
        this.catNombre = catNombre;
    }

    public String getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(String id_Categoria) {
        Id_Categoria = id_Categoria;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }
}