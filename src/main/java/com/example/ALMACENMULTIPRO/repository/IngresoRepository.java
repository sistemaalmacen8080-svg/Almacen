package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import java.util.List;

public interface IngresoRepository {

    List<Ingreso> listar();

    void guardar(Ingreso ingreso);

    Ingreso buscar(String id);

    void eliminar(String id);
}