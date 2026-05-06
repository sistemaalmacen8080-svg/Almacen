package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Usuario;
import java.util.List;

public interface UsuarioRepository {

    void guardar(Usuario usuario);

    List<Usuario> listar();

    void eliminar(String id);

    Usuario buscar(String id);

    void actualizar(Usuario usuario);
}