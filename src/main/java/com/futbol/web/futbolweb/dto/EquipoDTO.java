package com.futbol.web.futbolweb.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EquipoDTO extends NuevoEquipoDTO{
    private Long id;
    private List<JugadorDTO> jugadores;
    
}
