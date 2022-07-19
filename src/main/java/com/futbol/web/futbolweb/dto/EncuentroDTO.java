package com.futbol.web.futbolweb.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EncuentroDTO extends NuevoEncuentroDTO {

    private Long id;
    private List<EquipoDTO> equipos;
    
}
