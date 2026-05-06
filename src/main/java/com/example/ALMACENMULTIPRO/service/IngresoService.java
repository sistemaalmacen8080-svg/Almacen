package com.example.ALMACENMULTIPRO.service;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import java.util.List;

public interface IngresoService {

    List<Ingreso> listar();

    void guardar(Ingreso ingreso);

    Ingreso buscar(String id);

    void eliminar(String id);
}