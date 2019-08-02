package com.bxacosta.app01.controller;

import com.bxacosta.app01.dto.Persona;
import com.bxacosta.app01.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/persona")
    public List<Persona> list() {
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona find(@PathVariable Integer id) {
        return personaService.findOne(id);
    }

    @PostMapping("/persona")
    public Persona save(@RequestBody Persona cliente) {
        cliente.setId(null);
        return personaService.save(cliente);
    }

    @PutMapping("/persona/{id}")
    public Persona edit(@PathVariable Integer id, @RequestBody Persona persona) {
        var per = personaService.findOne(id);

        if (per != null) {
            persona.setId(id);
            return personaService.save(persona);
        } else {
            return null;
        }
    }

    @DeleteMapping("/persona/{id}")
    public void delete(@PathVariable Integer id) {
        personaService.delete(id);
    }
}
