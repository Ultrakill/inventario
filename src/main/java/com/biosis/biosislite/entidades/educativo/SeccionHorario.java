/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

import com.biosis.biosislite.entidades.Horario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Aldo
 */
@Entity
@Table(name="seccion_horario",schema="educativo")
public class SeccionHorario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seccion_horario_id")
    private Long id;
    @Column(name = "seccion_horario_fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "seccion_horario_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @ManyToOne(targetEntity = Seccion.class,fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "seccion_horario_seccion",referencedColumnName = "seccion_id")
    private Seccion seccion;
    @ManyToOne(targetEntity = Horario.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "seccion_horario_horario",referencedColumnName = "codigo")
    private Horario horario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
}
