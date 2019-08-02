package com.bxacosta.app02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDireccion {

    private Integer id;
    private String descripcion;
}
