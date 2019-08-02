package com.bxacosta.app02.controller;

import com.bxacosta.app02.dto.TipoDireccion;
import com.bxacosta.app02.service.TipoDireccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoDireccionController {

    private final TipoDireccionService tipoDireccionService;

    public TipoDireccionController(TipoDireccionService tipoDireccionService) {
        this.tipoDireccionService = tipoDireccionService;
    }

    @GetMapping("/tipo")
    public List<TipoDireccion> list() {
        return tipoDireccionService.findAll();
    }
}
