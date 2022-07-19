package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.EncuentroTorneoDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;
import com.futbol.web.futbolweb.exceptions.NoContentException;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Encuentro;
import com.futbol.web.futbolweb.models.Torneo;
import com.futbol.web.futbolweb.repositories.EncuentroRepository;
import com.futbol.web.futbolweb.repositories.TorneoRepository;
import com.futbol.web.futbolweb.services.EncuentroService;

@Service
public class EncuentroServiceImpl implements EncuentroService{

    final ModelMapper modelMapper;
    final EncuentroRepository encuentroRepository;
    final TorneoRepository torneoRepository;

    
    public EncuentroServiceImpl(TorneoRepository tr, EncuentroRepository repository, ModelMapper mapper){

        this.encuentroRepository=repository;
        this.modelMapper=mapper;
        this.torneoRepository = tr;
    }

    @Override
    @Transactional
    public EncuentroDTO create(Long idTorneo, NuevoEncuentroDTO encuentroDTO) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        encuentro.setTorneo(torneo);
        encuentroRepository.save(encuentro);
        return modelMapper.map(encuentro, EncuentroDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EncuentroTorneoDTO retrieve(Long idTorneo,Long id) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);

        return modelMapper.map(encuentro, EncuentroTorneoDTO.class);
    }

    @Override
    @Transactional
    public EncuentroTorneoDTO update(Long idTorneo,EncuentroDTO encuentroDTO, Long id) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        encuentro.setTorneo(torneo);
        encuentroRepository.save(encuentro);
        
        return (EncuentroTorneoDTO) modelMapper.map(encuentro, EncuentroDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long idTorneo,Long id) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        //encuentro.setId(id);
        encuentro.setTorneo(torneo);        
        encuentroRepository.deleteById(encuentro.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<EncuentroDTO> list(Long idTorneo) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        List<Encuentro> encuentros = encuentroRepository.findByTorneo(torneo);
        if(encuentros.isEmpty()) throw new NoContentException("Encuentros is empty");
        return encuentros.stream().map(encuentro -> modelMapper.map(encuentro, EncuentroDTO.class))
        .collect(Collectors.toList());
    }

    
}
