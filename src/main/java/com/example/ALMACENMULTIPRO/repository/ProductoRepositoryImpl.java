package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private final List<Producto> lista = new ArrayList<>();

    @Override
    public void guardar(Producto producto) {
        lista.add(producto);
    }

    @Override
    public List<Producto> listar() {
        return lista;
    }

    @Override
    public void eliminar(String id) {
        lista.removeIf(p -> p.getId_Producto().equals(id));
    }

    @Override
    public Producto buscarPorId(String id) {
        return lista.stream()
                .filter(p -> p.getId_Producto().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Producto producto) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId_Producto().equals(producto.getId_Producto())) {

                // 🔥 mantener stock
                producto.setStock(lista.get(i).getStock());

                lista.set(i, producto);
                break;
            }
        }
    }
}