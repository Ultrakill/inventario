/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

import com.biosis.biosislite.entidades.escalafon.Empleado;
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
@Table(schema = "educativo",name = "asignacion_ngs")
public class AsignacionNGS implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asignacion_ngs_id")
    private Long id;
    
    @Column(name = "asignacion_ngs_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "asignacion_ngs_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @ManyToOne(targetEntity = Empleado.class,fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "asignacion_ngs_responsable",referencedColumnName = "nro_documento")
    private Empleado responsable;
    
    @ManyToOne(targetEntity = Nivel.class,fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "asignacion_ngs_n",referencedColumnName = "nivel_id")
    private Nivel nivel;
    
    @ManyToOne(targetEntity = Grado.class,fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "asignacion_ngs_g",referencedColumnName = "grado_id")
    private Grado grado;
    
    @ManyToOne(targetEntity = Seccion.class,fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "asignacion_ngs_s",referencedColumnName = "seccion_id")
    private Seccion seccion;
    
    @Column(name = "asignacion_ngs_tipo")
    private Integer tipo;

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

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    
}
