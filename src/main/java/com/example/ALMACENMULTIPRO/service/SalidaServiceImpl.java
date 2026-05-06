package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.model.Salida;
import com.example.ALMACENMULTIPRO.repository.SalidaRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalidaServiceImpl implements SalidaService {

    private final SalidaRepository repository;
    private final ProductoService productoService;

    public SalidaServiceImpl(SalidaRepository repository,
                             ProductoService productoService) {
        this.repository = repository;
        this.productoService = productoService;
    }

    @Override
    public List<Salida> listar() {
        return repository.listar();
    }

    @Override
    public void guardar(Salida salida) {

        if (salida.getDetalles() == null) {
            salida.setDetalles(new ArrayList<>());
        }

        salida.getDetalles().forEach(d -> {

            Producto p = productoService.buscarPorId(d.getIdProducto());

            if (p != null) {

                // ✅ guardar nombre
                d.setNombreProducto(p.getProdNombre());

                // 🚨 VALIDAR STOCK
                if (p.getStock() < d.getCantidad()) {
                    throw new RuntimeException(
                            "Stock insuficiente para el producto: " + p.getProdNombre()
                    );
                }

                // 🔥 RESTAR STOCK
                p.setStock(p.getStock() - d.getCantidad());

                productoService.guardar(p);
            }
        });

        repository.guardar(salida);
    }

    @Override
    public Salida buscar(String id) {
        return repository.buscar(id);
    }

    @Override
    public void eliminar(String id) {
        repository.eliminar(id);
    }
}