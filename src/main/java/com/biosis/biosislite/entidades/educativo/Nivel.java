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
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Aldo
 */
@Entity
@Table(name="nivel",schema="educativo")
public class Nivel implements Serializable{
    @Column(name="nivel_id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name="nivel_nombre")
    @Basic
    private String nombre;
    @Column(name="nivel_abreviatura")
    @Basic
    private String abreviatura;
    @OneToMany(targetEntity = Grado.class,mappedBy = "nivel",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Grado> gradoList; 
    @OneToMany(targetEntity = AsignacionNGS.class,mappedBy = "nivel",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

    public List<Grado> getGradoList() {
        return gradoList;
    }

    public void setGradoList(List<Grado> gradoList) {
        this.gradoList = gradoList;
    }

    public List<AsignacionNGS> getAsignacionNGSList() {
        return asignacionNGSList;
    }

    public void setAsignacionNGSList(List<AsignacionNGS> asignacionNGSList) {
        this.asignacionNGSList = asignacionNGSList;
    }
    
    
}
