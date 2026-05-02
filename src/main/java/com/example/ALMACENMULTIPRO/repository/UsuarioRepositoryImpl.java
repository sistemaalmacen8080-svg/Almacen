package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final List<Usuario> listaUsuarios = new ArrayList<>();

    // Usuario por defecto (OBLIGATORIO)
    public UsuarioRepositoryImpl() {
        listaUsuarios.add(new Usuario(
                "U0001",
                "Almacen",
                "sistemaalmacen8080@gmail.com",
                "Almacen8080",
                "Administrador"
        ));
    }

    @Override
    public List<Usuario> listar() {
        return listaUsuarios;
    }

    @Override
    public void guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public void eliminar(String id) {
        listaUsuarios.removeIf(u -> u.getId_Usuario().equals(id));
    }

    @Override
    public Usuario buscarPorId(String id) {
        return listaUsuarios.stream()
                .filter(u -> u.getId_Usuario().equals(id))
                .findFirst()
                .orElse(null);
    }
}