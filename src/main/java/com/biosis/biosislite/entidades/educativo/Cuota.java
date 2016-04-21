/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.educativo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aldo
 */
@Entity
@Table(name = "cuota",schema = "educativo")
public class Cuota implements Serializable{
    
    @Column(name = "cuota_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "cuota_monto",nullable = false)
    @Basic
    private Float cuotaMonto;
    @Column(name = "cuota_fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date cuotaFechaVencimiento;
    @Column(name = "cuota_fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date cuotaFechaPago;
    @Column(name = "cuota_estado",nullable = false)
    @Basic
    private Integer cuotaEstado;
    @ManyToOne(targetEntity = Pago.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cuota_pago_id",referencedColumnName = "pago_id")
    private Pago pago;

    public Cuota(){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCuotaMonto() {
        return cuotaMonto;
    }

    public void setCuotaMonto(Float cuotaMonto) {
        this.cuotaMonto = cuotaMonto;
    }

    public Date getCuotaFechaVencimiento() {
        return cuotaFechaVencimiento;
    }

    public void setCuotaFechaVencimiento(Date cuotaFechaVencimiento) {
        this.cuotaFechaVencimiento = cuotaFechaVencimiento;
    }

    public Date getCuotaFechaPago() {
        return cuotaFechaPago;
    }

    public void setCuotaFechaPago(Date cuotaFechaPago) {
        this.cuotaFechaPago = cuotaFechaPago;
    }

    public Integer getCuotaEstado() {
        return cuotaEstado;
    }

    public void setCuotaEstado(Integer cuotaEstado) {
        this.cuotaEstado = cuotaEstado;
    }

    public Pago getCuotaPago() {
        return pago;
    }

    public void setCuotaPago(Pago pago) {
        this.pago = pago;
    }
    
    
    
}
