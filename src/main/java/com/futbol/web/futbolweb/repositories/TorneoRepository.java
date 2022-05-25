package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Torneo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository <Torneo, Long>{
    
}
