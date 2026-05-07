package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.repository.ProductoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(
            ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    @Override
    public void guardarProducto(Producto producto) {

        productoRepository.guardarProducto(producto);
    }

    @Override
    public List<Producto> listarProductos() {

        return productoRepository.listarProductos();
    }

    @Override
    public void eliminarProducto(String id) {

        productoRepository.eliminarProducto(id);
    }

    @Override
    public Producto buscarProducto(String id) {

        return productoRepository.buscarProducto(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {

        productoRepository.actualizarProducto(producto);
    }
}