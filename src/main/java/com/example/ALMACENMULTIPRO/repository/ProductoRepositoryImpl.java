package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private final List<Producto> listaProductos = new ArrayList<>();

    @Override
    public void guardarProducto(Producto producto) {

        if (producto.getId_Producto() == null ||
                producto.getId_Producto().isEmpty()) {

            producto.setId_Producto(generarIdProducto());
        }

        listaProductos.add(producto);
    }

    @Override
    public List<Producto> listarProductos() {

        return listaProductos;
    }

    @Override
    public Producto buscarProducto(String id) {

        return listaProductos.stream()
                .filter(
                        p -> p.getId_Producto().equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarProducto(String id) {

        listaProductos.removeIf(
                p -> p.getId_Producto().equals(id)
        );
    }

    @Override
    public void actualizarProducto(Producto producto) {

        Producto existente =
                buscarProducto(producto.getId_Producto());

        if (existente != null) {

            existente.setProdNombre(
                    producto.getProdNombre()
            );

            existente.setProdCategoria(
                    producto.getProdCategoria()
            );

            existente.setProdOperador(
                    producto.getProdOperador()
            );

            existente.setStock(
                    producto.getStock()
            );
        }
    }

    @Override
    public String generarIdProducto() {

        int siguiente =
                listaProductos.size() + 1;

        return String.format("P%04d", siguiente);
    }
}