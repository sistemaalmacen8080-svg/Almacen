package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngresoRepositoryImpl
        implements IngresoRepository {

    private final List<Ingreso> listaIngresos =
            new ArrayList<>();

    @Override
    public void guardarIngreso(Ingreso ingreso) {

        if (ingreso.getId_Ingreso() == null ||
                ingreso.getId_Ingreso().isEmpty()) {

            ingreso.setId_Ingreso(
                    generarIdIngreso()
            );

            listaIngresos.add(ingreso);

            return;
        }

        Ingreso existente =
                buscarIngreso(
                        ingreso.getId_Ingreso()
                );

        if (existente != null) {

            existente.setIngProveedor(
                    ingreso.getIngProveedor()
            );

            existente.setIngResponsable(
                    ingreso.getIngResponsable()
            );

            existente.setIngFecha(
                    ingreso.getIngFecha()
            );

            existente.setIngHora(
                    ingreso.getIngHora()
            );

            existente.setDetalles(
                    ingreso.getDetalles()
            );

        } else {

            listaIngresos.add(ingreso);
        }
    }

    @Override
    public List<Ingreso> listarIngresos() {

        return listaIngresos;
    }

    @Override
    public Ingreso buscarIngreso(String id) {

        return listaIngresos.stream()
                .filter(
                        i -> i.getId_Ingreso().equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarIngreso(String id) {

        listaIngresos.removeIf(
                i -> i.getId_Ingreso().equals(id)
        );
    }

    @Override
    public String generarIdIngreso() {

        int siguiente =
                listaIngresos.size() + 1;

        return String.format(
                "ING%04d",
                siguiente
        );
    }
}