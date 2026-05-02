package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Salida;

import java.util.List;

public interface SalidaService {

    List<Salida> listar();

    void guardar(Salida salida);

    Salida buscar(String id);

    void eliminar(String id);
}