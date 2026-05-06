package com.example.ALMACENMULTIPRO.repository;

import com.example.ALMACENMULTIPRO.model.Salida;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalidaRepositoryImpl implements SalidaRepository {

    private final List<Salida> lista = new ArrayList<>();

    @Override
    public List<Salida> listar() {
        return lista;
    }

    @Override
    public void guardar(Salida salida) {
        lista.add(salida);
    }

    @Override
    public Salida buscar(String id) {
        return lista.stream()
                .filter(s -> s.getId_Salida().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        lista.removeIf(s -> s.getId_Salida().equals(id));
    }
}