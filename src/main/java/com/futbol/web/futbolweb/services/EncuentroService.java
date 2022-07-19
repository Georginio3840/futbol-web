package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.EncuentroTorneoDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;

public interface EncuentroService {
    public EncuentroDTO create (Long idTorneo,NuevoEncuentroDTO encuentroDTO);
    public EncuentroTorneoDTO retrieve (Long idTorneo,Long id);
    public EncuentroTorneoDTO update(Long idTorneo,EncuentroDTO encuentroDTO, Long id);
    public void delete(Long idTorneo,Long id);

    public List<EncuentroDTO> list(Long idTorneo);
    
}
