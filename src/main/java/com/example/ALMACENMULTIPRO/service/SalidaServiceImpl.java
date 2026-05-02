package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.*;
import com.example.ALMACENMULTIPRO.repository.SalidaRepository;
import com.example.ALMACENMULTIPRO.repository.IngresoRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalidaServiceImpl implements SalidaService {

    private final SalidaRepository repository;
    private final IngresoRepository ingresoRepository;
    private final ProductoService productoService;

    public SalidaServiceImpl(SalidaRepository repository,
                             IngresoRepository ingresoRepository,
                             ProductoService productoService) {
        this.repository = repository;
        this.ingresoRepository = ingresoRepository;
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

            // STOCK TOTAL DESDE INGRESOS
            int stockIngresado = ingresoRepository.listar().stream()
                    .flatMap(i -> i.getDetalles().stream())
                    .filter(x -> x.getIdProducto() != null &&
                            x.getIdProducto().equals(d.getIdProducto()))
                    .mapToInt(DetalleIngreso::getCantidad)
                    .sum();

            // STOCK YA SALIDO
            int stockSalido = repository.listar().stream()
                    .flatMap(s -> s.getDetalles().stream())
                    .filter(x -> x.getIdProducto() != null &&
                            x.getIdProducto().equals(d.getIdProducto()))
                    .mapToInt(DetalleSalida::getCantidad)
                    .sum();

            int stockDisponible = stockIngresado - stockSalido;

            // VALIDACIÓN
            if (d.getCantidad() > stockDisponible) {
                throw new RuntimeException("Stock insuficiente para producto: " + d.getIdProducto());
            }

            // nombre del producto
            d.setNombreProducto(
                    productoService.listar().stream()
                            .filter(p -> p.getId_Producto().equals(d.getIdProducto()))
                            .map(Producto::getProdNombre)
                            .findFirst()
                            .orElse("Desconocido")
            );
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