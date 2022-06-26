package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;

public interface EquipoService {
    public EquipoDTO create (NuevoEquipoDTO equipoDTO);
    public EquipoDTO retrieve (Long id);
    public EquipoDTO update(EquipoDTO equipoDTO, Long id);
    public void delete(Long id);

    public List<EquipoDTO> list();
    
}
