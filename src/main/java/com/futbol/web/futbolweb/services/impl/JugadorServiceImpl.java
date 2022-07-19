package com.futbol.web.futbolweb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;
import com.futbol.web.futbolweb.exceptions.NoContentException;
import com.futbol.web.futbolweb.exceptions.ResourceNotFoundException;
import com.futbol.web.futbolweb.models.Encuentro;
import com.futbol.web.futbolweb.models.Equipo;
import com.futbol.web.futbolweb.models.Jugador;
import com.futbol.web.futbolweb.models.Torneo;
import com.futbol.web.futbolweb.repositories.EncuentroRepository;
import com.futbol.web.futbolweb.repositories.EquipoRepository;
import com.futbol.web.futbolweb.repositories.JugadorRepository;
import com.futbol.web.futbolweb.repositories.TorneoRepository;
import com.futbol.web.futbolweb.services.JugadorService;

@Service
public class JugadorServiceImpl implements JugadorService {

    final ModelMapper modelMapper;
    final JugadorRepository jugadorRepository;
    final EquipoRepository equipoRepository;
    final EncuentroRepository encuentroRepository;
    final TorneoRepository torneoRepository;

    public JugadorServiceImpl(JugadorRepository repository, ModelMapper mapper, EncuentroRepository er, TorneoRepository tr, EquipoRepository eqr) {
        this.jugadorRepository=repository;
        this.modelMapper=mapper;
        this.equipoRepository=eqr;
        this.encuentroRepository = er;
        this.torneoRepository = tr;
    }

    @Override
    @Transactional
    public List<JugadorDTO> create(Long idTorneo, Long idEncuentro, Long idEquipo, List<NuevoJugadorDTO> jugadores) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);
        Equipo equipo = equipoRepository.findById(idEquipo)
            .orElseThrow(()-> new ResourceNotFoundException("Equipo not found"));
        equipo.setEncuentro(encuentro);

        List<JugadorDTO> result = new ArrayList<JugadorDTO>();
        for(NuevoJugadorDTO ju : jugadores){
            Jugador jugador = modelMapper.map(ju, Jugador.class);
            jugador.setEquipo(equipo);
            jugadorRepository.save(jugador);
            result.add(modelMapper.map(jugador, JugadorDTO.class));
        }
        return result;
    }


    @Override
    @Transactional
    public void remove(Long idTorneo,Long idEncuentro, Long idEquipo) {
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);
        Equipo equipo = equipoRepository.findById(idEquipo)
            .orElseThrow(()-> new ResourceNotFoundException("Equipo not found"));
        equipo.setEncuentro(encuentro);
        
        if(equipo.getJugadores().isEmpty()) throw new NoContentException("Jugador is empty");
        equipo.getJugadores().forEach(ju -> {
            jugadorRepository.delete(ju);            
        });
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> list(Long idTorneo,Long idEncuentro, Long idEquipo) {
        
        Torneo torneo = torneoRepository.findById(idTorneo)
            .orElseThrow(()-> new ResourceNotFoundException("Torneo not found"));
        Encuentro encuentro = encuentroRepository.findById(idEncuentro)
            .orElseThrow(()-> new ResourceNotFoundException("Encuentro not found"));
        encuentro.setTorneo(torneo);
        Equipo equipo = equipoRepository.findById(idEquipo)
            .orElseThrow(()-> new ResourceNotFoundException("Equipo not found"));
        equipo.setEncuentro(encuentro);
    
        if(equipo.getJugadores().isEmpty()) throw new NoContentException("Jugador is empty");
        return equipo.getJugadores().stream().map(ju -> modelMapper.map(ju, JugadorDTO.class))
        .collect(Collectors.toList());
    }
    
}
