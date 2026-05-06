package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void guardar(Usuario usuario) {
        repository.guardar(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }

    @Override
    public void eliminar(String id) {
        repository.eliminar(id);
    }

    @Override
    public Usuario buscar(String id) {
        return repository.buscar(id);
    }

    @Override
    public void actualizar(Usuario usuario) {
        repository.actualizar(usuario);
    }
}