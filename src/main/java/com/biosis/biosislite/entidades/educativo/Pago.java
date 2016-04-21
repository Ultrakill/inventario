/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aldo
 */
@Entity
@Table(name = "pago",schema = "educativo")
public class Pago implements Serializable{
    
    @Column(name="pago_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @ManyToOne(targetEntity = Matricula.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "pago_matricula",referencedColumnName = "matricula_id")
    private Matricula matricula;
    @Column(name = "pago_monto",nullable = false)
    @Basic
    private Float monto;
    @Column(name = "pago_fecha_limite")
    @Temporal(TemporalType.DATE)
    private Date pagoFechaLimite;
    @Column(name = "pago_estado")
    @Basic
    private Integer pagoEstado;
    
    @OneToMany(fetch = FetchType.EAGER,targetEntity = Cuota.class, mappedBy = "pago")
    private List<Cuota> cuotaList;
    
    public Pago(){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getPagoFechaLimite() {
        return pagoFechaLimite;
    }

    public void setPagoFechaLimite(Date pagoFechaLimite) {
        this.pagoFechaLimite = pagoFechaLimite;
    }

    public Integer getPagoEstado() {
        return pagoEstado;
    }

    public void setPagoEstado(Integer pagoEstado) {
        this.pagoEstado = pagoEstado;
    }

    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }
    
}
