package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    
}
