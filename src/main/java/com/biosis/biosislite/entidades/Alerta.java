/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "alerta")
public class Alerta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alerta_id")
    private Long id;
    
    @Column(name = "alerta_descripcion")
    private String descripcion;
    
    @Column(name = "alerta_tipo")
    private Integer tipo;
    
    @Column(name = "alerta_estado")
    private Integer estado;
    
    @ManyToOne(targetEntity = Empleado.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "alerta_persona",referencedColumnName = "nro_documento")
    private Empleado empleado;
    
    @Column(name = "alerta_fecha_creacion")
    @Temporal(value = TemporalType.DATE)
    private Date fechaCreacion;

    @OneToMany(targetEntity = Notificacion.class,mappedBy = "alerta",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Notificacion> notificacionList;
    
    @OneToMany(targetEntity = AlertaIncidencia.class,mappedBy = "alerta",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AlertaIncidencia> alertaIncidenciaList;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    public List<AlertaIncidencia> getAlertaIncidenciaList() {
        return alertaIncidenciaList;
    }

    public void setAlertaIncidenciaList(List<AlertaIncidencia> alertaIncidenciaList) {
        this.alertaIncidenciaList = alertaIncidenciaList;
    }
    
    
}
