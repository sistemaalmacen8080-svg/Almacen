package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Ingreso;

import java.util.List;

public interface IngresoRepository {

    void guardarIngreso(Ingreso ingreso);

    List<Ingreso> listarIngresos();

    Ingreso buscarIngreso(String id);

    void eliminarIngreso(String id);

    String generarIdIngreso();
}