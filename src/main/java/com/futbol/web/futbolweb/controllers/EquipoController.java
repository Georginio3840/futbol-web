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

import com.futbol.web.futbolweb.dto.EquipoDTO;
import com.futbol.web.futbolweb.dto.NuevoEquipoDTO;
import com.futbol.web.futbolweb.services.EquipoService;

@RestController
@RequestMapping("/torneos")
public class EquipoController {

    private final EquipoService service;
    

    @Autowired
    public  EquipoController(EquipoService srv){
        this.service =srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/encuentro/{idEncuentro}/equipos")
    public ResponseEntity<List<EquipoDTO>> create(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro, @Valid @RequestBody List<NuevoEquipoDTO> equiposDTO){
        List<EquipoDTO> result = service.create(id, idEncuentro, equiposDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);      
    }
    

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}/encuentro/{idEncuentro}/equipos")
    public ResponseEntity<List<EquipoDTO>> delete(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro){
        service.remove(id, idEncuentro);
        return ResponseEntity.noContent().build();      
    }
    
    /* ================ LIST ================ */
    @GetMapping("/{id}/encuentro/{idEncuentro}/equipos") 
    public ResponseEntity<List<EquipoDTO>> list(@PathVariable("id") Long id, @PathVariable("idEncuentro") Long idEncuentro){
        List<EquipoDTO> result  = service.list(id, idEncuentro);
        return ResponseEntity.status(HttpStatus.OK).body(result);        
    }
    
}
