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
@Table(name="TBL_ENCUENTROS")
@Getter
@Setter
public class Encuentro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MARCADOR")
    private Integer marcador;

    @Column(name = "FECHA")
    private String fecha;

    @Column(name = "HORA")
    private String hora;

    @ManyToOne
    @JoinColumn(name="TORNEO_ID", nullable=false)
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name="ESTADIO_ID", nullable=false)
    private Estadio estadio;

    @ManyToOne
    @JoinColumn(name = "ARBITRO_ID", nullable = false)
    private Arbitro arbitro;

    @ManyToOne
    @JoinColumn(name = "EQUIPO_ID", nullable = false)
    private Equipo equipo;
    
    
}
