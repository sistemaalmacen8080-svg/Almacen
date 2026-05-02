package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Ingreso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngresoRepositoryImpl implements IngresoRepository {

    private final List<Ingreso> lista = new ArrayList<>();

    @Override
    public List<Ingreso> listar() {
        return lista;
    }

    @Override
    public void guardar(Ingreso ingreso) {
        lista.add(ingreso);
    }

    @Override
    public Ingreso buscar(String id) {
        return lista.stream()
                .filter(i -> i.getId_Ingreso().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public void eliminar(String id) {
        lista.removeIf(i -> i.getId_Ingreso().equals(id));
    }

}