/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Aldo
 */
@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "notificacion_asunto")
    private String asunto;
    
    @Column(name = "notificacion_mensaje")
    private String mensaje;
    
    @Column(name = "notificacion_fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    
    @Column(name = "notificacion_fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    
    @ManyToOne(targetEntity = Empleado.class,optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "notificacion_emisor",referencedColumnName = "nro_documento")
    private Empleado emisor;
    
    @ManyToOne(targetEntity = Empleado.class,optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "notificacion_receptor",referencedColumnName = "nro_documento")
    private Empleado receptor;
    
    @Column(name = "notificacion_tipo")
    private Integer tipo;
    
    @Column(name = "notificacion_estado")
    private Integer estado;
    
    @ManyToOne(targetEntity = Alerta.class,optional = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "notificacion_alerta",referencedColumnName = "alerta_id")
    private Alerta alerta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Empleado getEmisor() {
        return emisor;
    }

    public void setEmisor(Empleado emisor) {
        this.emisor = emisor;
    }

    public Empleado getReceptor() {
        return receptor;
    }

    public void setReceptor(Empleado receptor) {
        this.receptor = receptor;
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

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    
    
    
}
