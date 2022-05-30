package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;

public interface EquipoService {
    public EquipoService create (NuevoEquipoDTO equipoDTO);
    public EquipoService retrive (long id) throws Exception;
    public EquipoService update(EquipoDTO equipoDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<EquipoDTO> list();
    
}
