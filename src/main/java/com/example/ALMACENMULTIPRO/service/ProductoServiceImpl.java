package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.service.ProductoService;
import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    public List<Producto> listar() {

        return repository.listar();
    }
    @Override
    public void eliminar(String id) {
        repository.eliminar(id);
    }

    @Override
    public Producto buscarPorId(String id) {
        return repository.buscarPorId(id);
    }
}