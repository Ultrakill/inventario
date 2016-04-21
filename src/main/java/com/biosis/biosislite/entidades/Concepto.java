/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Aldo
 */
@Entity
@Table(name = "concepto")
public class Concepto implements Serializable{
    
    @EmbeddedId
    private ConceptoId id;
    @Column(name = "descripcion",nullable = false)
    @Basic
    private String descripcion;
    @Column(name = "abreviatura", nullable = true)
    @Basic
    private String abreviatura;
    @Column(name = "estado",nullable = true)
    @Basic
    private Integer estado;
    @Column(name = "tipo",nullable = true)
    @Basic
    private Integer tipo;
    @Column(name = "texto1",nullable = true)
    @Basic
    private String texto1;
    @Column(name = "texto2",nullable = true)
    @Basic
    private String texto2;
    @Column(name = "fecha1",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecha1;
    @Column(name = "fecha2",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecha2;
    @Column(name = "monto1",nullable = true)
    @Basic
    private Float monto1;
    @Column(name = "monto2",nullable = true)
    @Basic
    private Float monto2;
    @Column(name = "cor1",nullable = true)
    @Basic
    private Integer cor1;
    @Column(name = "cor2",nullable = true)
    @Basic
    private Integer cor2;
    @Column(name = "char1",nullable = true)
    @Basic
    private String char1;
    @Column(name = "char2",nullable = true)
    @Basic
    private String char2;
    @Column(name = "fechapro",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechapro;
    @Column(name = "horapro",nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horapro;
    @Column(name = "usuario",nullable = false)
    @Basic
    private String usuario;
    
    public Concepto(){}

    public ConceptoId getId() {
        return id;
    }

    public void setId(ConceptoId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Float getMonto1() {
        return monto1;
    }

    public void setMonto1(Float monto1) {
        this.monto1 = monto1;
    }

    public Float getMonto2() {
        return monto2;
    }

    public void setMonto2(Float monto2) {
        this.monto2 = monto2;
    }

    public Integer getCor1() {
        return cor1;
    }

    public void setCor1(Integer cor1) {
        this.cor1 = cor1;
    }

    public Integer getCor2() {
        return cor2;
    }

    public void setCor2(Integer cor2) {
        this.cor2 = cor2;
    }

    public String getChar1() {
        return char1;
    }

    public void setChar1(String char1) {
        this.char1 = char1;
    }

    public String getChar2() {
        return char2;
    }

    public void setChar2(String char2) {
        this.char2 = char2;
    }

    public Date getFechapro() {
        return fechapro;
    }

    public void setFechapro(Date fechapro) {
        this.fechapro = fechapro;
    }

    public Date getHorapro() {
        return horapro;
    }

    public void setHorapro(Date horapro) {
        this.horapro = horapro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}


