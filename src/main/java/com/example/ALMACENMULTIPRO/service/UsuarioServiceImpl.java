package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.guardar(usuario);
    }

    @Override
    public void eliminar(String id) {
        usuarioRepository.eliminar(id);
    }

    @Override
    public Usuario buscarPorId(String id) {
        return usuarioRepository.buscarPorId(id);
    }
}