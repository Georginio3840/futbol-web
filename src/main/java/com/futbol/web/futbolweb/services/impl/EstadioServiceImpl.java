package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.EstadioDTO;
import com.futbol.web.futbolweb.dto.NuevoEstadioDTO;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Estadio;
import com.futbol.web.futbolweb.repositories.EstadioRepository;
import com.futbol.web.futbolweb.services.EstadioService;

@Service
public class EstadioServiceImpl implements EstadioService{

    final ModelMapper modelMapper;
    final EstadioRepository estadioRepository;

    @Autowired
    public EstadioServiceImpl(@Autowired EstadioRepository repository, ModelMapper mapper){
        this.estadioRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public EstadioDTO create(NuevoEstadioDTO estadioDTO) {
        Estadio estadio = modelMapper.map(estadioDTO, Estadio.class);
        estadioRepository.save(estadio);
        return modelMapper.map(estadio, EstadioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EstadioDTO retrieve(Long id) {
        Estadio estadio = estadioRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Estadio not found"));

        return modelMapper.map(estadio, EstadioDTO.class);
    }

    @Override
    @Transactional
    public EstadioDTO update(EstadioDTO estadioDTO, Long id) {
        Estadio estadio = estadioRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Estadio not found"));
        estadio.setId(id);
        estadio = modelMapper.map(estadioDTO, Estadio.class);
        estadioRepository.save(estadio);
        
        return modelMapper.map(estadio, EstadioDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Estadio estadio = estadioRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Estadio not found"));
        estadio.setId(id);
        
        estadioRepository.deleteById(estadio.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstadioDTO> list() {
        List<Estadio> estadios = estadioRepository.findAll();
        return estadios.stream().map(estadio -> modelMapper.map(estadio, EstadioDTO.class))
        .collect(Collectors.toList());
    }
    
}
