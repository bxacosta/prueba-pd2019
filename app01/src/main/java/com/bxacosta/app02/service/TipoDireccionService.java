package com.bxacosta.app02.service;

import com.bxacosta.app02.dto.TipoDireccion;
import com.bxacosta.app02.mapper.TipoDireccionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDireccionService {

 private final JdbcTemplate jdbcTemplate;

    public TipoDireccionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TipoDireccion> findAll() {
        String query = "SELECT * FROM tipo_direccion";
        return jdbcTemplate.query(query, new TipoDireccionMapper());
    }
}
