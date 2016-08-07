package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.lang.Long;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="detalle_movimiento", schema = "inventario")
public  class DetalleMovimiento implements Serializable {


    @Column(name="id",table="detalle_movimiento",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
//    @Column(name="fecha")
//    @Temporal(TemporalType.TIMESTAMP)
//    @Basic
//    private Date fecha;
//    
//    @Column(name="detalle")
//    @Basic
//    private String detalle;

    @ManyToOne(optional=false,targetEntity=Bien_Inventario.class)
    @JoinColumn(name="inventario_id",referencedColumnName="id")
    private Bien_Inventario inventario;

        

    @ManyToOne(optional=false,targetEntity=Movimiento.class)
    @JoinColumn(name="movimiento_id",referencedColumnName="id")
    private Movimiento movimiento;
    
//    @ManyToOne(optional=false,targetEntity=Ambiente.class)
//    @JoinColumn(name="ambiente_codigo_origen",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
//    private Ambiente ambienteOrigen;
//    
//    @ManyToOne(optional=false,targetEntity=Ambiente.class)
//    @JoinColumn(name="ambiente_codigo_origen",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
//    private Ambiente ambienteActual;
//    
//    @ManyToOne(optional=false,targetEntity=Ambiente.class)
//    @JoinColumn(name="ambiente_codigo_destino",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
//    private Ambiente ambienteDestino;

    public DetalleMovimiento(){

    }


   public long getId() {
        return this.id;
    }


  public void setId (long id) {
        this.id = id;
    }



   public Bien_Inventario getInventario() {
        return this.inventario;
    }


  public void setInventario (Bien_Inventario inventario) {
        this.inventario = inventario;
    }

   public Movimiento getMovimiento() {
        return this.movimiento;
    }


  public void setMovimiento (Movimiento movimiento) {
        this.movimiento = movimiento;
    }
  
//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
//
//    public String getDetalle() {
//        return detalle;
//    }
//
//    public void setDetalle(String detalle) {
//        this.detalle = detalle;
//    }
//
//    public Ambiente getAmbienteOrigen() {
//        return ambienteOrigen;
//    }
//
//    public void setAmbienteOrigen(Ambiente ambienteOrigen) {
//        this.ambienteOrigen = ambienteOrigen;
//    }
//
//    public Ambiente getAmbienteActual() {
//        return ambienteActual;
//    }
//
//    public void setAmbienteActual(Ambiente ambienteActual) {
//        this.ambienteActual = ambienteActual;
//    }
//
//    public Ambiente getAmbienteDestino() {
//        return ambienteDestino;
//    }
//
//    public void setAmbienteDestino(Ambiente ambienteDestino) {
//        this.ambienteDestino = ambienteDestino;
//    }

  
  
}

