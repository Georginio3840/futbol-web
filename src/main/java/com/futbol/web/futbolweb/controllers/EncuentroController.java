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

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;
import com.futbol.web.futbolweb.services.EncuentroService;

@RestController
@RequestMapping("/encuentros")
public class EncuentroController {

    private final EncuentroService service;

    @Autowired
    public EncuentroController(EncuentroService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<EncuentroDTO> create(@Valid @RequestBody NuevoEncuentroDTO encuentroDTO){
        EncuentroDTO result = service.create(encuentroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EncuentroDTO> retrive(@PathVariable("id") Long id){
        EncuentroDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<EncuentroDTO>> list(){
        List<EncuentroDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncuentroDTO> update(@RequestBody EncuentroDTO encuentroDTO, @PathVariable("id") Long id){
        EncuentroDTO result = service.update(encuentroDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Encuentro deleted!");        
    }
    
}
