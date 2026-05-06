package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final List<Usuario> lista = new ArrayList<>();

    // 🔥 USUARIO ADMIN POR DEFECTO
    public UsuarioRepositoryImpl() {

        Usuario admin = new Usuario();
        admin.setId_Usuario("U001");
        admin.setUsuNombre("Administrador");
        admin.setUsuCorreo("admin@multipro.com");
        admin.setUsuContraseña("1234");
        admin.setUsuRol("ADMIN");

        lista.add(admin);
    }

    @Override
    public List<Usuario> listar() {
        return lista;
    }

    @Override
    public void guardar(Usuario usuario) {
        lista.add(usuario);
    }

    @Override
    public Usuario buscar(String id) {
        return lista.stream()
                .filter(u -> u.getId_Usuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminar(String id) {

        // ❌ PROTEGER ADMIN
        if (id.equals("U001")) {
            return;
        }

        lista.removeIf(u -> u.getId_Usuario().equals(id));
    }

    @Override
    public void actualizar(Usuario usuario) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId_Usuario().equals(usuario.getId_Usuario())) {

                lista.set(i, usuario);
                break;
            }
        }
    }
}