package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.repository.IngresoRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoServiceImpl
        implements IngresoService {

    private final IngresoRepository ingresoRepository;
    private final ProductoService productoService;

    public IngresoServiceImpl(
            IngresoRepository ingresoRepository,
            ProductoService productoService) {

        this.ingresoRepository =
                ingresoRepository;

        this.productoService =
                productoService;
    }

    @Override
    public List<Ingreso> listarIngresos() {

        return ingresoRepository.listarIngresos();
    }

    @Override
    public void guardarIngreso(Ingreso ingreso) {

        if (ingreso.getDetalles() == null) {

            ingreso.setDetalles(
                    new ArrayList<>()
            );
        }

        ingreso.getDetalles().forEach(d -> {

            Producto producto =
                    productoService.buscarProducto(
                            d.getIdProducto()
                    );

            if (producto != null) {

                d.setNombreProducto(
                        producto.getProdNombre()
                );

                producto.setStock(
                        producto.getStock()
                                + d.getCantidad()
                );

                productoService.actualizarProducto(producto);
            }
        });

        ingresoRepository.guardarIngreso(
                ingreso
        );
    }

    @Override
    public Ingreso buscarIngreso(String id) {

        return ingresoRepository.buscarIngreso(id);
    }

    @Override
    public void eliminarIngreso(String id) {

        ingresoRepository.eliminarIngreso(id);
    }
}