package com.futbol.web.futbolweb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_TORNEOS")
@Getter
@Setter
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_INICIO")
    private String fecha_inicio;

    @Column(name = "FECHA_FIN")
    private String fecha_fin;

    @OneToMany(mappedBy = "torneo")
    private List<Encuentro> encuentros;
    
}
