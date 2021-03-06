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

import com.futbol.web.futbolweb.dto.NuevoTorneoDTO;
import com.futbol.web.futbolweb.dto.TorneoDTO;
import com.futbol.web.futbolweb.services.TorneoService;

@RestController
@RequestMapping("/torneos")
public class TorneoController {

    private final TorneoService service;

    @Autowired
    public TorneoController(TorneoService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<TorneoDTO> create(@Valid @RequestBody NuevoTorneoDTO torneoDTO){
        TorneoDTO result = service.create(torneoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TorneoDTO> retrive(@PathVariable("id") Long id){
        TorneoDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<TorneoDTO>> list(){
        List<TorneoDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<TorneoDTO> update(@RequestBody TorneoDTO torneoDTO, @PathVariable("id") Long id){
        TorneoDTO result = service.update(torneoDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Torneo deleted!");        
    }
    
}
