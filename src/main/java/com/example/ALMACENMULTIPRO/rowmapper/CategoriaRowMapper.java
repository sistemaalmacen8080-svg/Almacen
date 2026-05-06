package com.example.ALMACENMULTIPRO.rowmapper;

import com.example.ALMACENMULTIPRO.model.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaRowMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {

        Categoria categoria = new Categoria();

        categoria.setId_Categoria(rs.getString("Id_Categoria"));
        categoria.setCatNombre(rs.getString("catNombre"));

        return categoria;
    }
}