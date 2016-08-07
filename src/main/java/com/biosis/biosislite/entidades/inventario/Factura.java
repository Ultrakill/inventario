package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="factura", schema = "inventario")
public  class Factura implements Serializable {


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien_Inventario.class,mappedBy="factura")
    private List<Bien_Inventario> inventarioList;


    @Column(name="id",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fecha;


    @Column(name="numero_factura")
    @Basic
    private String numeroFactura;


    @Column(name="ruta")
    @Basic
    private String ruta;

    public Factura(){

    }


   public List<Bien_Inventario> getInventarioList() {
        return this.inventarioList;
    }


  public void setInventarioList (List<Bien_Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public String getNumeroFactura() {
        return this.numeroFactura;
    }


  public void setNumeroFactura (String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }



   public String getRuta() {
        return this.ruta;
    }


  public void setRuta (String ruta) {
        this.ruta = ruta;
    }

}

