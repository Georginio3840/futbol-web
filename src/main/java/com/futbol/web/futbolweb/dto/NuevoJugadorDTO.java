package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NuevoJugadorDTO {
    private String nombre;
    private String apellido;
    private String cedula;
    private String sexo;
    private Integer edad;
    private String posicion;
    private Integer numero;
    private String descripcion;
    
}
