package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EquipoDTO {
    private Long id;
    private String nombre;
    private String uniforme;
    private String tecnico;
    
}
