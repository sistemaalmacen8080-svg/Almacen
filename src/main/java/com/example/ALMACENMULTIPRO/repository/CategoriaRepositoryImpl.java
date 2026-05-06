package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Categoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private static final List<Categoria> categorias = new ArrayList<>();

    @Override
    public List<Categoria> listarCategorias() {
        return categorias;
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    @Override
    public Categoria buscarPorId(String id) {

        for (Categoria categoria : categorias) {
            if (categoria.getId_Categoria().equals(id)) {
                return categoria;
            }
        }

        return null;
    }

    @Override
    public void actualizarCategoria(Categoria categoriaActualizada) {

        for (Categoria categoria : categorias) {

            if (categoria.getId_Categoria().equals(categoriaActualizada.getId_Categoria())) {
                categoria.setCatNombre(categoriaActualizada.getCatNombre());
                break;
            }
        }
    }

    @Override
    public void eliminarCategoria(String id) {

        categorias.removeIf(categoria -> categoria.getId_Categoria().equals(id));
    }
}