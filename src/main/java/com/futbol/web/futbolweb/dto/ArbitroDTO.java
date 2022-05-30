package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class ArbitroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String licencia;
    private String telefono;
}
