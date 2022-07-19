package com.futbol.web.futbolweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.web.futbolweb.dto.EncuentroDTO;
import com.futbol.web.futbolweb.dto.EncuentroTorneoDTO;
import com.futbol.web.futbolweb.dto.NuevoEncuentroDTO;
import com.futbol.web.futbolweb.services.EncuentroService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/torneos")
public class EncuentroController {

    private final EncuentroService service;

    @Autowired
    public EncuentroController(EncuentroService srv){
        this.service =srv;
    }
    /* ================ CREATE ================ */
    @PostMapping("/{id}/encuentros")
    public ResponseEntity<EncuentroDTO> create(@PathVariable("id") Long id,@Valid @RequestBody NuevoEncuentroDTO encuentroDTO){
        EncuentroDTO result = service.create(id,encuentroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    
    /* ================ RETRIEVE ================ */
    @GetMapping("/{idTorneo}/encuentros/{id}")
    public ResponseEntity<EncuentroDTO> retrive(@PathVariable("idTorneo") Long idTorneo,@PathVariable("id") Long id){
        EncuentroTorneoDTO result = service.retrieve(idTorneo,id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{idTorneo}/encuentros/{id}")
    public ResponseEntity<EncuentroDTO> update( @PathVariable("idTorneo") Long idTorneo, @RequestBody EncuentroDTO encuentroDTO, @PathVariable("id") Long id){
        EncuentroTorneoDTO result = service.update(idTorneo,encuentroDTO, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{idTorneo}/encuentros/{id}")
    public ResponseEntity<String> delete(@PathVariable("idTorneo") Long idTorneo,@PathVariable("id") Long id){
        service.delete(idTorneo,id);
        return ResponseEntity.noContent().build();     
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/encuentros") //el verbo es diferente a create ya que va
    public ResponseEntity<List<EncuentroDTO>> list(@PathVariable("id") Long id){
        List<EncuentroDTO> result  = service.list(id);
        return ResponseEntity.ok().body(result);        
    }

}
