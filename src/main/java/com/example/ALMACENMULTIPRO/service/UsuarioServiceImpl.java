package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository) {

        this.usuarioRepository =
                usuarioRepository;
    }

    @Override
    public void guardarUsuario(
            Usuario usuario) {

        usuarioRepository.guardarUsuario(
                usuario
        );
    }

    @Override
    public List<Usuario> listarUsuarios() {

        return usuarioRepository.listarUsuarios();
    }

    @Override
    public void eliminarUsuario(String id) {

        usuarioRepository.eliminarUsuario(id);
    }

    @Override
    public Usuario buscarUsuario(String id) {

        return usuarioRepository.buscarUsuario(id);
    }

    @Override
    public void actualizarUsuario(
            Usuario usuario) {

        usuarioRepository.actualizarUsuario(
                usuario
        );
    }
}