package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository <Equipo,Long>{
    
}
