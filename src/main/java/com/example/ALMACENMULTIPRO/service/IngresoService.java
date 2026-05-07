package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Ingreso;

import java.util.List;

public interface IngresoService {

    List<Ingreso> listarIngresos();

    void guardarIngreso(Ingreso ingreso);

    Ingreso buscarIngreso(String id);

    void eliminarIngreso(String id);
}