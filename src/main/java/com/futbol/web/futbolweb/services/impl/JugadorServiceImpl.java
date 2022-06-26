package com.futbol.web.futbolweb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Jugador;
import com.futbol.web.futbolweb.repositories.JugadorRepository;
import com.futbol.web.futbolweb.services.JugadorService;

@Service
public class JugadorServiceImpl implements JugadorService {

    final ModelMapper modelMapper;
    final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorServiceImpl(@Autowired JugadorRepository repository, ModelMapper mapper) {
        this.jugadorRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public JugadorDTO create(NuevoJugadorDTO jugadorDTO) {
        Jugador jugador = modelMapper.map(jugadorDTO, Jugador.class);
        jugadorRepository.save(jugador);
        return modelMapper.map(jugador, JugadorDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public JugadorDTO retrieve(long id) {
        Jugador jugador = jugadorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Jugador not found"));

        return modelMapper.map(jugador, JugadorDTO.class);
    }

    @Override
    @Transactional
    public JugadorDTO update(JugadorDTO jugadorDTO, Long id) {
        Jugador jugador = jugadorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Jugador not found"));
        jugador.setId(id);
        jugador = modelMapper.map(jugadorDTO, Jugador.class);
        jugadorRepository.save(jugador);
        
        return modelMapper.map(jugador, JugadorDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Jugador not found"));
        jugador.setId(id);
        
        jugadorRepository.deleteById(jugador.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> list() {
        
        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores.stream().map(jugador -> modelMapper.map(jugador, JugadorDTO.class))
        .collect(Collectors.toList());
    }
    
}
