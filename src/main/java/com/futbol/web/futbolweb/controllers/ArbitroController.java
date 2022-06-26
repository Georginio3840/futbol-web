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

import com.futbol.web.futbolweb.dto.ArbitroDTO;
import com.futbol.web.futbolweb.dto.NuevoArbitroDTO;
import com.futbol.web.futbolweb.services.ArbitroService;

@RestController
@RequestMapping("/arbitros")
public class ArbitroController {
    private final ArbitroService service;

    @Autowired
    public ArbitroController(ArbitroService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ArbitroDTO> create(@Valid @RequestBody NuevoArbitroDTO arbitroDTO){
        ArbitroDTO result = service.create(arbitroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ArbitroDTO> retrive(@PathVariable("id") Long id){
        ArbitroDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<ArbitroDTO>> list(){
        List<ArbitroDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArbitroDTO> update(@RequestBody ArbitroDTO arbitroDTO, @PathVariable("id") Long id){
        ArbitroDTO result = service.update(arbitroDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Arbitro deleted!");        
    }
}
