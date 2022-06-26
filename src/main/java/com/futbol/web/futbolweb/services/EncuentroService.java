package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;

public interface EncuentroService {
    public EncuentroDTO create (NuevoEncuentroDTO encuentroDTO);
    public EncuentroDTO retrieve (Long id);
    public EncuentroDTO update(EncuentroDTO encuentroDTO, Long id);
    public void delete(Long id);

    public List<EncuentroDTO> list();
    
}
