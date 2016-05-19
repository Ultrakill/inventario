/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author Aldo
 */
@Entity
@Table(name = "alerta_incidencia")
public class AlertaIncidencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alerta_incidencia_id")
    private Long id;
    
    @ManyToOne(targetEntity = Alerta.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "alerta_incidencia_alerta",referencedColumnName = "alerta_id")
    private Alerta alerta;
    
    @OneToOne(targetEntity = Incidencia.class)
    @JoinColumn(name = "alerta_incidencia_incidencia",referencedColumnName = "incidencia_id")
    private Incidencia incidencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
    
}
