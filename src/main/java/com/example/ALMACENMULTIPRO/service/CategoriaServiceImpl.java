package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Categoria;
import com.example.ALMACENMULTIPRO.repository.CategoriaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl
        implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(
            CategoriaRepository categoriaRepository) {

        this.categoriaRepository =
                categoriaRepository;
    }

    @Override
    public List<Categoria> listarCategorias() {

        return categoriaRepository.listarCategorias();
    }

    @Override
    public void guardarCategoria(
            Categoria categoria) {

        categoriaRepository.guardarCategoria(
                categoria
        );
    }

    @Override
    public Categoria buscarCategoria(String id) {

        return categoriaRepository.buscarCategoria(id);
    }

    @Override
    public void actualizarCategoria(
            Categoria categoria) {

        categoriaRepository.actualizarCategoria(
                categoria
        );
    }

    @Override
    public void eliminarCategoria(String id) {

        categoriaRepository.eliminarCategoria(id);
    }
}