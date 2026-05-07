package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Salida;

import java.util.List;

public interface SalidaService {

    List<Salida> listarSalidas();

    void guardarSalida(Salida salida);

    Salida buscarSalida(String id);

    void eliminarSalida(String id);
}