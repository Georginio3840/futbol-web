package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.NuevoTorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoListDTO;
import com.futbol.web.futbolweb.exceptions.NoContentException;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Torneo;
import com.futbol.web.futbolweb.repositories.TorneoRepository;
import com.futbol.web.futbolweb.services.TorneoService;

@Service
public class TorneoServiceImpl implements TorneoService {
    
    final ModelMapper modelMapper;
    final TorneoRepository torneoRepository;

    
    public TorneoServiceImpl(TorneoRepository repository, ModelMapper mapper){

        this.torneoRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public TorneoDTO create(NuevoTorneoDTO torneoDTO) {
        Torneo torneo = modelMapper.map(torneoDTO, Torneo.class);
        torneoRepository.save(torneo);
        return modelMapper.map(torneo, TorneoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public TorneoDTO retrieve(Long id) {
        Torneo torneo = torneoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));

        return modelMapper.map(torneo, TorneoDTO.class);
    }

    @Override
    @Transactional
    public TorneoDTO update(TorneoDTO torneoDTO, Long id) {
        Torneo torneo = torneoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        torneo.setId(id);
        torneo = modelMapper.map(torneoDTO, Torneo.class);
        torneoRepository.save(torneo);
        
        return modelMapper.map(torneo, TorneoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Torneo torneo = torneoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        torneo.setId(id);
        
        torneoRepository.deleteById(torneo.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<TorneoListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Torneo> torneos = torneoRepository.findAll(pageable);
        if(torneos.isEmpty()) throw new NoContentException("Torneo is empty");
        return torneos.stream().map(torneo -> modelMapper.map(torneo, TorneoListDTO.class))
            .collect(Collectors.toList());  
    }

    @Override
    public long count() {        
        return torneoRepository.count();
    }

}
