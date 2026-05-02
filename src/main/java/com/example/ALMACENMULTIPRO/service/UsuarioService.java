package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    void guardar(Usuario usuario);

    void eliminar(String id);

    Usuario buscarPorId(String id);
}