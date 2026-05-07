package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl
        implements UsuarioRepository {

    private final List<Usuario> listaUsuarios =
            new ArrayList<>();

    public UsuarioRepositoryImpl() {

        Usuario admin = new Usuario();

        admin.setId_Usuario("U0001");
        admin.setUsuNombre(
                "Administrador del Almacén"
        );

        admin.setUsuCorreo(
                "sistemaalmacen8080@gmail.com"
        );

        admin.setUsuContraseña("1234");

        admin.setUsuRol("Administrador");

        listaUsuarios.add(admin);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {

        // NUEVO USUARIO
        if (usuario.getId_Usuario() == null ||
                usuario.getId_Usuario().isEmpty()) {

            usuario.setId_Usuario(
                    generarIdUsuario()
            );

            listaUsuarios.add(usuario);

            return;
        }

        // ACTUALIZAR
        Usuario existente =
                buscarUsuario(
                        usuario.getId_Usuario()
                );

        if (existente != null) {

            existente.setUsuNombre(
                    usuario.getUsuNombre()
            );

            existente.setUsuCorreo(
                    usuario.getUsuCorreo()
            );

            existente.setUsuContraseña(
                    usuario.getUsuContraseña()
            );

            existente.setUsuRol(
                    usuario.getUsuRol()
            );

        } else {

            listaUsuarios.add(usuario);
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {

        return listaUsuarios;
    }

    @Override
    public Usuario buscarUsuario(String id) {

        return listaUsuarios.stream()
                .filter(
                        u -> u.getId_Usuario().equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarUsuario(String id) {

        // PROTEGER ADMIN
        if (id.equals("U0001")) {
            return;
        }

        listaUsuarios.removeIf(
                u -> u.getId_Usuario().equals(id)
        );
    }

    @Override
    public void actualizarUsuario(
            Usuario usuario) {

        Usuario existente =
                buscarUsuario(
                        usuario.getId_Usuario()
                );

        if (existente != null) {

            existente.setUsuNombre(
                    usuario.getUsuNombre()
            );

            existente.setUsuCorreo(
                    usuario.getUsuCorreo()
            );

            existente.setUsuContraseña(
                    usuario.getUsuContraseña()
            );

            existente.setUsuRol(
                    usuario.getUsuRol()
            );
        }
    }

    @Override
    public String generarIdUsuario() {

        int siguiente =
                listaUsuarios.size() + 1;

        return String.format(
                "U%04d",
                siguiente
        );
    }
}