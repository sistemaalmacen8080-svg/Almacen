package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;

import java.util.List;

public interface UsuarioService {

    void guardar(Usuario usuario);

    List<Usuario> listar();

    void eliminar(String id);

    Usuario buscar(String id);

    void actualizar(Usuario usuario);
}