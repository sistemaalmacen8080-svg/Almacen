package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Usuario;
import java.util.List;

public interface UsuarioRepository {

    List<Usuario> listar();

    void guardar(Usuario usuario);

    void eliminar(String id);

    Usuario buscarPorId(String id);
}