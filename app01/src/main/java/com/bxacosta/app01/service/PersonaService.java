package com.bxacosta.app01.service;

import com.bxacosta.app01.dto.Persona;
import com.bxacosta.app01.mapper.PersonaMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final JdbcTemplate jdbcTemplate;

    public PersonaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Persona save(Persona item) {
        if (item.getId() != null) {
            Persona persona = findOne(item.getId());
            if (persona != null) {
                String query = "UPDATE persona SET cedula = ?, tipo_direccion = ?,nombre = ?, direccion = ?  WHERE id = ?";
                jdbcTemplate.update(query, item.getCedula(), item.getTipoDireccion(), item.getNombre(), item.getDireccion(), item.getId());
                return item;
            }
        }

        String query = "INSERT INTO persona (cedula, tipo_direccion, nombre, direccion) VALUES (?, ?, ? ,?)";
        jdbcTemplate.update(query, item.getCedula(), item.getTipoDireccion(), item.getNombre(), item.getDireccion());
        return item;
    }

    public Persona findOne(Integer id) {
        String query = "SELECT * FROM persona WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new PersonaMapper());
    }

    public List<Persona> findAll() {
        String query = "SELECT * FROM persona";
        return jdbcTemplate.query(query, new PersonaMapper());
    }

    public void delete(Integer id) {
        String query = "DELETE FROM persona WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
