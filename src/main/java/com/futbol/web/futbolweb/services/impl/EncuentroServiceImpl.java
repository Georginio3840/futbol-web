package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Encuentro;
import com.futbol.web.futbolweb.repositories.EncuentroRepository;
import com.futbol.web.futbolweb.services.EncuentroService;

@Service
public class EncuentroServiceImpl implements EncuentroService{

    final ModelMapper modelMapper;
    final EncuentroRepository encuentroRepository;

    @Autowired
    public EncuentroServiceImpl(@Autowired EncuentroRepository repository, ModelMapper mapper){

        this.encuentroRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public EncuentroDTO create(NuevoEncuentroDTO encuentroDTO) {
        Encuentro encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        encuentroRepository.save(encuentro);
        return modelMapper.map(encuentro, EncuentroDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EncuentroDTO retrieve(Long id) {
        Encuentro encuentro = encuentroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));

        return modelMapper.map(encuentro, EncuentroDTO.class);
    }

    @Override
    @Transactional
    public EncuentroDTO update(EncuentroDTO encuentroDTO, Long id) {
        Encuentro encuentro = encuentroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setId(id);
        encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        encuentroRepository.save(encuentro);
        
        return modelMapper.map(encuentro, EncuentroDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Encuentro encuentro = encuentroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setId(id);
        
        encuentroRepository.deleteById(encuentro.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<EncuentroDTO> list() {

        List<Encuentro> encuentros = encuentroRepository.findAll();
        return encuentros.stream().map(encuentro -> modelMapper.map(encuentro, EncuentroDTO.class))
        .collect(Collectors.toList());
    }

    
}
