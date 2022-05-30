package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;

public interface JugadorService {
    
    public JugadorService create (NuevoJugadorDTO jugadorDTO);
    public JugadorService retrive (long id) throws Exception;
    public JugadorService update(JugadorDTO jugadorDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<JugadorDTO> list();

}
