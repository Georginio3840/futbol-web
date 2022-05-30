package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EncuentroDTO {
    
    private Long id;
    private Integer marcador;
    private String fecha;
    private String hora;
}
