package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;

public interface JugadorService {
    
    public JugadorDTO create (NuevoJugadorDTO jugadorDTO);
    public JugadorDTO retrieve (long id);
    public JugadorDTO update(JugadorDTO jugadorDTO, Long id);
    public void delete(Long id);

    public List<JugadorDTO> list();

}
