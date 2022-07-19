package com.futbol.web.futbolweb.repositories;

import com.futbol.web.futbolweb.models.Encuentro;
import com.futbol.web.futbolweb.models.Torneo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuentroRepository extends JpaRepository<Encuentro, Long>{
        public List<Encuentro> findByTorneo(Torneo torneo);
}
