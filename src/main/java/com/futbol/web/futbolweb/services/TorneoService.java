package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.NuevoTorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoDTO;

public interface TorneoService {
    
    public TorneoDTO create (NuevoTorneoDTO  torneoDTO);
    public TorneoDTO retrieve (Long id);
    public TorneoDTO update(TorneoDTO torneoDTO,Long id);
    public void delete(Long id);

    public List<TorneoDTO> list();
}
