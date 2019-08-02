package com.bxacosta.app02.mapper;


import com.bxacosta.app02.dto.TipoDireccion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoDireccionMapper implements RowMapper<TipoDireccion> {

    @Override
    public TipoDireccion mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TipoDireccion.builder()
                .id(rs.getInt("id"))
                .descripcion(rs.getString("descripcion"))
                .build();
    }
}
