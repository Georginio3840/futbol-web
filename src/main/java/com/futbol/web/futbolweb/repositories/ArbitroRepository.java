package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Arbitro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Long>{
    
}
