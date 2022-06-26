package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NuevoTorneoDTO {
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    
}
