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

import com.futbol.web.futbolweb.dto.EstadioDTO;
import com.futbol.web.futbolweb.dto.NuevoEstadioDTO;
import com.futbol.web.futbolweb.services.EstadioService;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioService service;
    

    @Autowired
    public  EstadioController(EstadioService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<EstadioDTO> create(@Valid @RequestBody NuevoEstadioDTO estadioDTO){
        EstadioDTO result = service.create(estadioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EstadioDTO> retrive(@PathVariable("id") Long id){
        EstadioDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<EstadioDTO>> list(){
        List<EstadioDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadioDTO> update(@RequestBody EstadioDTO estadioDTO, @PathVariable("id") Long id){
        EstadioDTO result = service.update(estadioDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Estadio deleted!");        
    }
    
}
