package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;

public interface JugadorService {
    
    public List<JugadorDTO> create (Long idTorneo, Long idEncuentro, Long idEquipo, List<NuevoJugadorDTO> list);
    public List<JugadorDTO> list(Long idTorneo, Long idEncuentro, Long idEquipo);
    public void remove(Long idTorneo, Long idEncuentro, Long idEquipo);
}
