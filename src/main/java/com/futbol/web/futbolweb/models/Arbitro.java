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

@Entity //
@Table(name="TBL_ARBITROS")
@Getter
@Setter

public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CEDULA")
    private String cedula;

    @Column(name = "LICENCIA")
    private String licencia;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    //@OneToMany(mappedBy="arbitro")
    //private List<Encuentro> encuentros;

    
}
