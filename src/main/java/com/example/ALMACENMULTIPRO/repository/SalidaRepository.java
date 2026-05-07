package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Salida;

import java.util.List;

public interface SalidaRepository {

    void guardarSalida(Salida salida);

    List<Salida> listarSalidas();

    Salida buscarSalida(String id);

    void eliminarSalida(String id);

    String generarIdSalida();
}