package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;

public interface EncuentroService {
    public EncuentroService create (NuevoEncuentroDTO encuentroDTO);
    public EncuentroService retrive (long id) throws Exception;
    public EncuentroService update(EncuentroDTO encuentroDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<EncuentroDTO> list();
    
}
