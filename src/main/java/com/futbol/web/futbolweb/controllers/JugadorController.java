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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.web.futbolweb.dto.JugadorDTO;
import com.futbol.web.futbolweb.dto.NuevoJugadorDTO;
import com.futbol.web.futbolweb.services.JugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService service;

    @Autowired
    public JugadorController(JugadorService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<JugadorDTO> create(@Valid @RequestBody NuevoJugadorDTO jugadorDTO){
        JugadorDTO result = service.create(jugadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> retrive(@PathVariable("id") Long id){
        JugadorDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<JugadorDTO>> list(){
        List<JugadorDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> update(@RequestBody JugadorDTO jugadorDTO, @PathVariable("id") Long id){
        JugadorDTO result = service.update(jugadorDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Jugador deleted!");        
    }
    
}
