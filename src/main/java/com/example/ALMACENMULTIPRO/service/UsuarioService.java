package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;

import java.util.List;

public interface UsuarioService {

    void guardarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    void eliminarUsuario(String id);

    Usuario buscarUsuario(String id);

    void actualizarUsuario(Usuario usuario);
}