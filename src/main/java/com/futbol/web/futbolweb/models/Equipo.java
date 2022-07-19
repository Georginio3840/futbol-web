package com.futbol.web.futbolweb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_EQUIPOS")
@Getter
@Setter
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "UNIFORME")
    private String uniforme;

    @Column(name = "TECNICO")
    private String tecnico;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "ENCUENTRO_ID", nullable = false)
    private Encuentro encuentro;

    
    
}
