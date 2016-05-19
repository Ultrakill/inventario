/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades;

/**
 *
 * @author Aldo
 */
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "incidencia")
public class Incidencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incidencia_id")
    private Long id;
    
    @Column(name = "incidencia_fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne(optional=true,targetEntity = Empleado.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "incidencia_persona",referencedColumnName = "nro_documento")
    private Empleado empleado;
    
    @Column(name = "incidencia_minutos")
    private Integer minutos;
    
    @Column(name = "incidencia_tipo")
    private Integer tipo;
    
    @Column(name = "incidencia_estado")
    private Integer estado;
    
    @ManyToOne(targetEntity = DetalleJornada.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "incidencia_det_jornada",referencedColumnName = "dtjorn_id")
    private DetalleJornada detalleJornada;

    @OneToOne(targetEntity = AlertaIncidencia.class,mappedBy = "incidencia")
    private AlertaIncidencia alertaIncidencia;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
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

    public DetalleJornada getDetalleJornada() {
        return detalleJornada;
    }

    public void setDetalleJornada(DetalleJornada detalleJornada) {
        this.detalleJornada = detalleJornada;
    }

    public AlertaIncidencia getAlertaIncidencia() {
        return alertaIncidencia;
    }

    public void setAlertaIncidencia(AlertaIncidencia alertaIncidencia) {
        this.alertaIncidencia = alertaIncidencia;
    }
    
    
}
