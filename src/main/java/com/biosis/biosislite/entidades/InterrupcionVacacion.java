/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author RyuujiMD
 */
@Entity
@Table(name = "interrupcion_vacacion")
public class InterrupcionVacacion implements Serializable {
    @Id
    @Column(name = "intvac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "intvac_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "intvac_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "intvac_motivo")
    private String motivo;
    @OneToOne(targetEntity = Vacacion.class)
    @JoinColumn(name = "vac_id",referencedColumnName = "id")
    private Vacacion vacacion;
    
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "empleado_id",referencedColumnName = "nro_documento")
    private Empleado empleado;
    
    @ManyToOne(targetEntity = Periodo.class)
    @JoinColumn(name = "periodo_id", referencedColumnName = "anio")
    private Periodo periodo;

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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Vacacion getVacacion() {
        return vacacion;
    }

    public void setVacacion(Vacacion vacacion) {
        this.vacacion = vacacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    
    
}
