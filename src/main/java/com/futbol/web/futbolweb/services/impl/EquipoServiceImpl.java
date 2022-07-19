package com.futbol.web.futbolweb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;
import com.futbol.web.futbolweb.exceptions.NoContentException;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Encuentro;
import com.futbol.web.futbolweb.models.Equipo;
import com.futbol.web.futbolweb.models.Torneo;
import com.futbol.web.futbolweb.repositories.EncuentroRepository;
import com.futbol.web.futbolweb.repositories.EquipoRepository;
import com.futbol.web.futbolweb.repositories.TorneoRepository;
import com.futbol.web.futbolweb.services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    final ModelMapper modelMapper;
    final EquipoRepository equipoRepository;
    final EncuentroRepository encuentroRepository;
    final TorneoRepository torneoRepository;

    public EquipoServiceImpl(EquipoRepository repository, ModelMapper mapper, EncuentroRepository er, TorneoRepository tr){

        this.equipoRepository=repository;
        this.modelMapper=mapper;
        this.encuentroRepository = er;
        this.torneoRepository = tr;
        
    }

    @Override
    @Transactional
    public List<EquipoDTO> create(Long idTorneo, Long idEncuentro, List<NuevoEquipoDTO> equipos) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);
        
        List<EquipoDTO> result = new ArrayList<EquipoDTO>();
        for(NuevoEquipoDTO eq : equipos){
            Equipo equipo = modelMapper.map(eq, Equipo.class);
            equipo.setEncuentro(encuentro);
            equipoRepository.save(equipo);
            result.add(modelMapper.map(equipo, EquipoDTO.class));
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipoDTO> list(Long idTorneo,Long idEncuentro) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);
        if(encuentro.getEquipos().isEmpty()) throw new NoContentException("Equipo is empty");
        return encuentro.getEquipos().stream().map(eq -> modelMapper.map(eq, EquipoDTO.class))
        .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void remove(Long idTorneo,Long idEncuentro) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Equipo not found"));
        encuentro.setTorneo(torneo);
        if(encuentro.getEquipos().isEmpty()) throw new NoContentException("Equipo is empty");
        encuentro.getEquipos().forEach(eq -> {
            equipoRepository.delete(eq);            
        });
        
    }
    
}
