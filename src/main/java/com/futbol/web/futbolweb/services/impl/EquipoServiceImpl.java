package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Equipo;
import com.futbol.web.futbolweb.repositories.EquipoRepository;
import com.futbol.web.futbolweb.services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    final ModelMapper modelMapper;
    final EquipoRepository equipoRepository;

    @Autowired
    public EquipoServiceImpl(@Autowired EquipoRepository repository, ModelMapper mapper){

        this.equipoRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public EquipoDTO create(NuevoEquipoDTO equipoDTO) {
        Equipo equipo = modelMapper.map(equipoDTO, Equipo.class);
        equipoRepository.save(equipo);
        return modelMapper.map(equipo, EquipoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EquipoDTO retrieve(Long id) {
        Equipo equipo = equipoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Equipo not found"));

        return modelMapper.map(equipo, EquipoDTO.class);
    }

    @Override
    @Transactional
    public EquipoDTO update(EquipoDTO equipoDTO, Long id) {
        Equipo equipo = equipoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Enquipo not found"));
        equipo.setId(id);
        equipo = modelMapper.map(equipoDTO, Equipo.class);
        equipoRepository.save(equipo);
        
        return modelMapper.map(equipo, EquipoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Equipo equipo = equipoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        equipo.setId(id);
        
        equipoRepository.deleteById(equipo.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipoDTO> list() {
        List<Equipo> equipos = equipoRepository.findAll();
        return equipos.stream().map(equipo -> modelMapper.map(equipo, EquipoDTO.class))
        .collect(Collectors.toList());
    }
    
}
