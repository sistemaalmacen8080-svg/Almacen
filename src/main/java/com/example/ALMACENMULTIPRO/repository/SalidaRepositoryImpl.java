package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Salida;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalidaRepositoryImpl
        implements SalidaRepository {

    private final List<Salida> listaSalidas =
            new ArrayList<>();

    @Override
    public void guardarSalida(Salida salida) {

        if (salida.getId_Salida() == null ||
                salida.getId_Salida().isEmpty()) {

            salida.setId_Salida(
                    generarIdSalida()
            );

            listaSalidas.add(salida);

            return;
        }

        Salida existente =
                buscarSalida(
                        salida.getId_Salida()
                );

        if (existente != null) {

            existente.setSalProveedor(
                    salida.getSalProveedor()
            );

            existente.setSalResponsable(
                    salida.getSalResponsable()
            );

            existente.setSalFecha(
                    salida.getSalFecha()
            );

            existente.setSalHora(
                    salida.getSalHora()
            );

            existente.setDetalles(
                    salida.getDetalles()
            );

        } else {

            listaSalidas.add(salida);
        }
    }

    @Override
    public List<Salida> listarSalidas() {

        return listaSalidas;
    }

    @Override
    public Salida buscarSalida(String id) {

        return listaSalidas.stream()
                .filter(
                        s -> s.getId_Salida().equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarSalida(String id) {

        listaSalidas.removeIf(
                s -> s.getId_Salida().equals(id)
        );
    }

    @Override
    public String generarIdSalida() {

        int siguiente =
                listaSalidas.size() + 1;

        return String.format(
                "SAL%04d",
                siguiente
        );
    }
}