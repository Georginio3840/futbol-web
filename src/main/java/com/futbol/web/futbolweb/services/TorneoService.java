package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.NuevoTorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoListDTO;

public interface TorneoService {
    
    public TorneoDTO create (NuevoTorneoDTO  torneoDTO);
    public TorneoDTO retrieve (Long id);
    public TorneoDTO update(TorneoDTO torneoDTO,Long id);
    public void delete(Long id);
    public long count();

    public List<TorneoListDTO> list(int page, int size, String sort);
}
