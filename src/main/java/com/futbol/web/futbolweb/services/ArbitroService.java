package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.ArbitroDTO;
import com.futbol.web.futbolweb.dto.NuevoArbitroDTO;


public interface ArbitroService {
 
    public ArbitroDTO create (NuevoArbitroDTO arbitroDTO);
    public ArbitroDTO retrive (long id) throws Exception;
    public ArbitroDTO update(ArbitroDTO arbitroDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<ArbitroDTO> list();


}
