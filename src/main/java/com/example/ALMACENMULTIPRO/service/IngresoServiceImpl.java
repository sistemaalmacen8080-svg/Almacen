package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.repository.IngresoRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoServiceImpl implements IngresoService {

    private final IngresoRepository repository;
    private final ProductoService productoService;

    public IngresoServiceImpl(IngresoRepository repository,
                              ProductoService productoService) {
        this.repository = repository;
        this.productoService = productoService;
    }

    @Override
    public List<Ingreso> listar() {
        return repository.listar();
    }

    @Override
    public void guardar(Ingreso ingreso) {

        if (ingreso.getDetalles() == null) {
            ingreso.setDetalles(new ArrayList<>());
        }

        ingreso.getDetalles().forEach(d -> {

            Producto p = productoService.buscarPorId(d.getIdProducto());

            if (p != null) {

                // ✅ guardar nombre del producto
                d.setNombreProducto(p.getProdNombre());

                // ✅ SUMAR stock real
                p.setStock(p.getStock() + d.getCantidad());

                productoService.guardar(p);
            }
        });

        repository.guardar(ingreso);
    }

    @Override
    public Ingreso buscar(String id) {
        return repository.buscar(id);
    }

    @Override
    public void eliminar(String id) {
        repository.eliminar(id);
    }
}