package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NuevoEstadioDTO {
    private String nombre;
    private String ubicacion;
    private Integer capacidad;    
}
