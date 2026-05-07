package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl
        implements CategoriaRepository {

    private final List<Categoria> listaCategorias =
            new ArrayList<>();

    @Override
    public void guardarCategoria(Categoria categoria) {

        // NUEVA CATEGORÍA
        if (categoria.getId_Categoria() == null ||
                categoria.getId_Categoria().isEmpty()) {

            categoria.setId_Categoria(
                    generarIdCategoria()
            );

            listaCategorias.add(categoria);

            return;
        }

        // ACTUALIZAR
        Categoria existente =
                buscarCategoria(
                        categoria.getId_Categoria()
                );

        if (existente != null) {

            existente.setCatNombre(
                    categoria.getCatNombre()
            );

        } else {

            listaCategorias.add(categoria);
        }
    }

    @Override
    public List<Categoria> listarCategorias() {

        return listaCategorias;
    }

    @Override
    public Categoria buscarCategoria(String id) {

        return listaCategorias.stream()
                .filter(
                        c -> c.getId_Categoria().equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarCategoria(String id) {

        listaCategorias.removeIf(
                c -> c.getId_Categoria().equals(id)
        );
    }

    @Override
    public void actualizarCategoria(
            Categoria categoria) {

        Categoria existente =
                buscarCategoria(
                        categoria.getId_Categoria()
                );

        if (existente != null) {

            existente.setCatNombre(
                    categoria.getCatNombre()
            );
        }
    }

    @Override
    public String generarIdCategoria() {

        int siguiente =
                listaCategorias.size() + 1;

        return String.format("C%04d", siguiente);
    }
}