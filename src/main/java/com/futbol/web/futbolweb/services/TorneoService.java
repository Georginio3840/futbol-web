package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.NuevoTorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoDTO;

public interface TorneoService {
    
    public TorneoService create (NuevoTorneoDTO  torneoDTO);
    public TorneoService retrive (long id) throws Exception;
    public TorneoService update(TorneoDTO torneoDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<TorneoDTO> list();
}
