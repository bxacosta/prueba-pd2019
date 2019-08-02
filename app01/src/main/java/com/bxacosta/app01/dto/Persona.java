package com.bxacosta.app01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Integer id;
    private String cedula;
    private String direccion;
    private Integer tipoDireccion;
    private String nombre;
}
