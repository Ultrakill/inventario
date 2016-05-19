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
@Table(name="seccion",schema = "educativo")
public class Seccion implements Serializable{
    
    @Column(name = "seccion_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name="seccion_nombre")
    @Basic
    private String nombre;
    @Column(name="seccion_abreviatura")
    private String abreviatura;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Grado.class)
    @JoinColumn(name = "seccion_grado",referencedColumnName = "grado_id")
    private Grado grado;
    @OneToMany(targetEntity = AsignacionNGS.class,mappedBy = "seccion",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AsignacionNGS> asignacionNGSList;
    @OneToMany(targetEntity = SeccionHorario.class,mappedBy = "seccion",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SeccionHorario> seccionHorarioList;
    @OneToMany(targetEntity = Matricula.class,mappedBy = "seccion",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Matricula> matriculaList;
            
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

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public List<AsignacionNGS> getAsignacionNGSList() {
        return asignacionNGSList;
    }

    public void setAsignacionNGSList(List<AsignacionNGS> asignacionNGSList) {
        this.asignacionNGSList = asignacionNGSList;
    }

    public List<SeccionHorario> getSeccionHorarioList() {
        return seccionHorarioList;
    }

    public void setSeccionHorarioList(List<SeccionHorario> seccionHorarioList) {
        this.seccionHorarioList = seccionHorarioList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
    
    
}
