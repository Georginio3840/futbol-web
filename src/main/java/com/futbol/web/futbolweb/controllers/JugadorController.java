package com.futbol.web.futbolweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;
import com.futbol.web.futbolweb.services.JugadorService;

@RestController
@RequestMapping("/torneos")
public class JugadorController {

    private final JugadorService service;

    @Autowired
    public JugadorController(JugadorService srv){
        this.service =srv;
    }
    /* ================ CREATE ================ */
    @PostMapping("/{id}/encuentro/{idEncuentro}/equipo/{idEquipo}/jugadores")
    public ResponseEntity<List<JugadorDTO>> create(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro, @PathVariable("idEquipo") Long idEquipo,@Valid @RequestBody List<NuevoJugadorDTO> jugadoresDTO){
        List<JugadorDTO> result = service.create(id, idEncuentro, idEquipo, jugadoresDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    /* ================ DELETE ================ */
    @DeleteMapping("/{id}/encuentro/{idEncuentro}/equipo/{idEquipo}/jugadores")
    public ResponseEntity<List<JugadorDTO>> retrive(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro, @PathVariable("idEquipo") Long idEquipo){
        service.remove(id, idEncuentro, idEquipo);
        return ResponseEntity.noContent().build();        
    }

    /* ================ LIST ================ */
    @GetMapping() 
    public ResponseEntity<List<JugadorDTO>> list(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro, @PathVariable("idEquipo") Long idEquipo){
        List<JugadorDTO> result  = service.list(id, idEncuentro, idEquipo);
        return ResponseEntity.status(HttpStatus.OK).body(result);          
    }
    
}
