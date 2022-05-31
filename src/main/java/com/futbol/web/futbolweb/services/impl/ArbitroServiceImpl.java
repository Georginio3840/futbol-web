package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.futbol.web.futbolweb.dto.ArbitroDTO;
import com.futbol.web.futbolweb.dto.NuevoArbitroDTO;
import com.futbol.web.futbolweb.models.Arbitro;
import com.futbol.web.futbolweb.repositories.ArbitroRepository;
import com.futbol.web.futbolweb.services.ArbitroService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbitroServiceImpl implements ArbitroService {
    
    final ModelMapper modelMapper;
    final ArbitroRepository arbitroRepository;

    @Autowired
    public ArbitroServiceImpl(@Autowired ArbitroRepository repository, ModelMapper mapper){
        this.arbitroRepository = repository;
        this.modelMapper = mapper;
    }
    //Crear
    @Override
    @Transactional
    public ArbitroDTO create(NuevoArbitroDTO arbitroDTO) {
        Arbitro arbitro = modelMapper.map(arbitroDTO, Arbitro.class);
        arbitroRepository.save(arbitro);
        ArbitroDTO arbitroDTOCreated = modelMapper.map(arbitro, ArbitroDTO.class); 
        return arbitroDTOCreated;
    }

    //Consultar
    @Override
    @Transactional(readOnly = true)
    public ArbitroDTO retrieve(Long id) throws Exception {
        Optional<Arbitro> arbitro = arbitroRepository.findById(id);
        if(arbitro.isEmpty()){
            throw new Exception("Exan not found");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(arbitro, ArbitroDTO.class);
    }

    //Actualizar
    @Override
    @Transactional
    public ArbitroDTO update(ArbitroDTO arbitroDTO) throws Exception {
        Arbitro arbitro = arbitroRepository.findById(arbitroDTO.getId())
                .orElseThrow(()-> new Exception("Exam not found"));
        
        arbitro = modelMapper.map(arbitroDTO, Arbitro.class);
        arbitroRepository.save(arbitro);       

        return modelMapper.map(arbitro, ArbitroDTO.class);
    }
    //eliminar
    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Arbitro arbitro = arbitroRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));        
        arbitroRepository.deleteById(arbitro.getId());      
        
        
    }
    @Override
    @Transactional(readOnly = true)
    public List<ArbitroDTO> list() {
        List<Arbitro> arbitros = arbitroRepository.findAll();
        return arbitros.stream().map(arbitro -> modelMapper.map(arbitro, ArbitroDTO.class))
            .collect(Collectors.toList());        
    }




    
}
