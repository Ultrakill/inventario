/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

import java.io.Serializable;
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
/**
 *
 * @author Aldo
 */
@Entity
@Table(name="grado",schema="educativo")
public class Grado implements Serializable{
    
    @Column(name="grado_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name="grado_nombre")
    @Basic
    private String nombre;
    @Column(name="grado_abreviatura")
    @Basic
    private String abreviatura;
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Nivel.class)
    @JoinColumn(name="grado_nivel",referencedColumnName = "nivel_id")
    private Nivel nivel;
    @OneToMany(targetEntity = Seccion.class,mappedBy = "grado",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Seccion> seccionList;
    @OneToMany(targetEntity = AsignacionNGS.class,mappedBy = "grado",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AsignacionNGS> asignacionNGSList;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Seccion> getSeccionList() {
        return seccionList;
    }

    public void setSeccionList(List<Seccion> seccionList) {
        this.seccionList = seccionList;
    }

    public List<AsignacionNGS> getAsignacionNGSList() {
        return asignacionNGSList;
    }

    public void setAsignacionNGSList(List<AsignacionNGS> asignacionNGSList) {
        this.asignacionNGSList = asignacionNGSList;
    }    
}
