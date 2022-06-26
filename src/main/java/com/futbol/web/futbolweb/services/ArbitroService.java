package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.ArbitroDTO;
import com.futbol.web.futbolweb.dto.NuevoArbitroDTO;


public interface ArbitroService {
 
    public ArbitroDTO create (NuevoArbitroDTO arbitroDTO);
    public ArbitroDTO retrieve (Long id);
    public ArbitroDTO update(ArbitroDTO arbitroDTO, Long id);
    public void delete(Long id);

    public List<ArbitroDTO> list();


}
