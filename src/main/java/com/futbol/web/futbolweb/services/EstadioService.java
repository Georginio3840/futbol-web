package com.futbol.web.futbolweb.services;

import java.util.List;

import com.futbol.web.futbolweb.dto.EstadioDTO;
import com.futbol.web.futbolweb.dto.NuevoEstadioDTO;

public interface EstadioService {
    
    public EstadioDTO create (NuevoEstadioDTO estadioDTODTO);
    public EstadioDTO retrieve (Long id);
    public EstadioDTO update(EstadioDTO encuentroDTO, Long id);
    public void delete(Long id);

    public List<EstadioDTO> list();
}
