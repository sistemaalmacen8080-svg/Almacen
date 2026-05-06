package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Salida;
import java.util.List;

public interface SalidaRepository {

    List<Salida> listar();

    void guardar(Salida salida);

    Salida buscar(String id);

    void eliminar(String id);
}