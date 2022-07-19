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
@Table(name="TBL_ESTADIOS")
@Getter
@Setter

public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "UBICACION")
    private String ubicacion; 

    @Column(name = "CAPACIDAD")
    private Integer capacidad;
    
    //@OneToMany(mappedBy="estadio")
    //private List<Encuentro> encuentros;
            
}
