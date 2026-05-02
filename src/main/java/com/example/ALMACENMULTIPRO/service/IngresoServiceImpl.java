package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.service.ProductoService;
import com.example.ALMACENMULTIPRO.model.Ingreso;
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
        // 🔥 aquí se calcula stock acumulado (SIMULADO)
        if (ingreso.getDetalles() != null) {
            ingreso.getDetalles().forEach(d -> {

                String nombre = productoService.listar().stream()
                        .filter(p -> p.getId_Producto().equals(d.getIdProducto()))
                        .map(Producto::getProdNombre)
                        .findFirst()
                        .orElse("Desconocido");

                d.setNombreProducto(nombre);

                int acumulado = repository.listar().stream()
                        .flatMap(i -> i.getDetalles().stream())
                        .filter(x -> x.getIdProducto() != null &&
                                x.getIdProducto().equals(d.getIdProducto()))
                        .mapToInt(x -> x.getCantidad())
                        .sum();

                d.setStockTotal(acumulado + d.getCantidad());
            });

        }

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