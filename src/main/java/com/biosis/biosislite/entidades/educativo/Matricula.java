/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

import com.biosis.biosislite.entidades.Periodo;
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
@Table(name="matricula",schema="educativo")
public class Matricula implements Serializable {
    
    @Column(name="matricula_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name="matricula_fecha")
    @Temporal(TemporalType.DATE)
    @Basic(fetch=FetchType.LAZY)
    private Date matriculaFecha;
    @ManyToOne(fetch=FetchType.EAGER,targetEntity = Empleado.class, optional = true)
    @JoinColumn(name = "matricula_alumno",referencedColumnName = "nro_documento")
    private Empleado alumno; 
//    @Column(name = "matricula_seccion",nullable = false)
//    @Basic
//    private Integer seccion;
    @ManyToOne(targetEntity = Seccion.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula_seccion",referencedColumnName = "seccion_id")
    private Seccion seccion;
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Empleado.class, optional = true)
    @JoinColumn(name = "matricula_apoderado",referencedColumnName = "nro_documento")
    private Empleado apoderado;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Periodo.class)
    @JoinColumn(name = "matricula_periodo",referencedColumnName = "anio")
    private Periodo matriculaPeriodo;
    
    @OneToMany(targetEntity = Pago.class, mappedBy = "matricula",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pago> pagoList;
    
    public Matricula(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMatriculaFecha() {
        return matriculaFecha;
    }

    public void setMatriculaFecha(Date matriculaFecha) {
        this.matriculaFecha = matriculaFecha;
    }

    public Empleado getAlumno() {
        return alumno;
    }

    public void setAlumno(Empleado alumno) {
        this.alumno = alumno;
    }

  

//    public Integer getSeccion() {
//        return seccion;
//    }
//
//    public void setSeccion(Integer seccion) {
//        this.seccion = seccion;
//    }

    public Empleado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Empleado apoderado) {
        this.apoderado = apoderado;
    }

    public Periodo getMatriculaPeriodo() {
        return matriculaPeriodo;
    }

    public void setMatriculaPeriodo(Periodo matriculaPeriodo) {
        this.matriculaPeriodo = matriculaPeriodo;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
    
}
