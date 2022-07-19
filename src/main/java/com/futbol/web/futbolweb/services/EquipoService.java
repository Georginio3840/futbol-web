package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;

public interface EquipoService {
    public List<EquipoDTO> create (Long idTorneo, Long idEncuentro, List<NuevoEquipoDTO> list);
    public List<EquipoDTO>  list(Long idTorneo,Long idEncuentro);
    public void remove(Long idTorneo,Long idEncuentro);    
}
