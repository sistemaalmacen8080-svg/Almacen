package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Categoria;

import java.util.List;

public interface CategoriaRepository {

    List<Categoria> listarCategorias();

    void guardarCategoria(Categoria categoria);

    Categoria buscarPorId(String id);

    void actualizarCategoria(Categoria categoria);

    void eliminarCategoria(String id);
}