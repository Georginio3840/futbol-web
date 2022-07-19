package com.futbol.web.futbolweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
/**
 * 
 */
@NoArgsConstructor
public class EncuentroTorneoDTO extends EncuentroDTO{
    private TorneoDTO torneo;
    
}
