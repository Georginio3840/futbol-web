package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EstadioDTO;
import com.futbol.web.futbolweb.dto.NuevoEstadioDTO;

public interface EstadioService {
    
    public EstadioService create (NuevoEstadioDTO estadioDTODTO);
    public EstadioService retrive (long id) throws Exception;
    public EstadioService update(EstadioDTO encuentroDTO) throws Exception;
    public void delete(Long id) throws Exception;

    public List<EstadioDTO> list();
}
