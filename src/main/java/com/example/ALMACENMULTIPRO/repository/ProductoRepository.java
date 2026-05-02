package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Producto;
import java.util.List;

public interface ProductoRepository {

    void guardar(Producto producto);

    List<Producto> listar();

    void eliminar(String id);
    Producto buscarPorId(String id);

}