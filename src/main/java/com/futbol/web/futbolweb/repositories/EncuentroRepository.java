package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Encuentro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuentroRepository extends JpaRepository<Encuentro, Long>{
    
}
