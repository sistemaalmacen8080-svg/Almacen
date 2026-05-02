package com.example.ALMACENMULTIPRO.model;

public class Usuario {

    private String id_Usuario;
    private String usuNombre;
    private String usuCorreo;
    private String usuContraseña;
    private String usuRol;

    // Constructor vacío (OBLIGATORIO)
    public Usuario() {
    }

    // Constructor completo
    public Usuario(String id_Usuario, String usuNombre, String usuCorreo, String usuContraseña, String usuRol) {
        this.id_Usuario = id_Usuario;
        this.usuNombre = usuNombre;
        this.usuCorreo = usuCorreo;
        this.usuContraseña = usuContraseña;
        this.usuRol = usuRol;
    }

    // GETTERS Y SETTERS

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuContraseña() {
        return usuContraseña;
    }

    public void setUsuContraseña(String usuContraseña) {
        this.usuContraseña = usuContraseña;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }
}