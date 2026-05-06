package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Producto;
import java.util.List;

public interface ProductoService {

    void guardar(Producto producto);

    List<Producto> listar();

    void eliminar(String id);

    Producto buscarPorId(String id);

    void actualizar(Producto producto); // 🔥 NUEVO
}