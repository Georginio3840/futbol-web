package com.futbol.web.futbolweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_JUGADORES")
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CEDULA")
    private String cedula;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "SEXO")
    private String sexo;
    
    @Column(name = "POSICION")
    private String posicion;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="EQUIPO_ID", nullable=false)
    private Equipo equipo;  
}
