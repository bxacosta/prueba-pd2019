package com.bxacosta.app02.mapper;

import com.bxacosta.app02.dto.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {

    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Persona.builder()
                .id(rs.getInt("id"))
                .cedula(rs.getString("cedula"))
                .direccion(rs.getString("direccion"))
                .tipoDireccion(rs.getInt("tipo_direccion"))
                .nombre(rs.getString("nombre"))
                .build();
    }
}
