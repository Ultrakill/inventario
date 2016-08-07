package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
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

@Entity
@Table(name="proveedor", schema = "inventario")
public  class Proveedor implements Serializable {


    @Column(name="id",table="proveedor",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="direccion",table="proveedor",length=45)
    @Basic
    private String direccion;


    @Column(name="nombreProveedor",table="proveedor",length=45)
    @Basic
    private String nombreProveedor;


    @Column(name="RUC",table="proveedor",length=45)
    @Basic
    private String ruc;


    @Column(name="Telefono",table="proveedor",length=45)
    @Basic
    private String telefono;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien_Inventario.class,mappedBy="proveedor")
    private List<Bien_Inventario> inventarios;

    public Proveedor(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getDireccion() {
        return this.direccion;
    }


  public void setDireccion (String direccion) {
        this.direccion = direccion;
    }



   public String getNombreProveedor() {
        return this.nombreProveedor;
    }


  public void setNombreProveedor (String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }



   public String getRuc() {
        return this.ruc;
    }


  public void setRuc (String ruc) {
        this.ruc = ruc;
    }



   public String getTelefono() {
        return this.telefono;
    }


  public void setTelefono (String telefono) {
        this.telefono = telefono;
    }



   public List<Bien_Inventario> getInventarios() {
        return this.inventarios;
    }


  public void setInventarios (List<Bien_Inventario> inventarios) {
        this.inventarios = inventarios;
    }

}

