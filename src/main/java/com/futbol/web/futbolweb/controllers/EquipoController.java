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

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;
import com.futbol.web.futbolweb.services.EquipoService;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService service;
    

    @Autowired
    public  EquipoController(EquipoService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<EquipoDTO> create(@Valid @RequestBody NuevoEquipoDTO equipoDTO){
        EquipoDTO result = service.create(equipoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> retrive(@PathVariable("id") Long id){
        EquipoDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<EquipoDTO>> list(){
        List<EquipoDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoDTO> update(@RequestBody EquipoDTO equipoDTO, @PathVariable("id") Long id){
        EquipoDTO result = service.update(equipoDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Equipo deleted!");        
    }
    
}
