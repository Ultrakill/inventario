package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo", schema = "inventario")
public  class Tipo implements Serializable {


    @Column(name="nombre",table="tipo",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="tipo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @OneToMany(targetEntity=Clase.class,mappedBy="tipo")
    private List<Clase> clases;

    public Tipo(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public List<Clase> getClases() {
        return this.clases;
    }


  public void setClases (List<Clase> clases) {
        this.clases = clases;
    }

    @Override
    public String toString() {
        return nombre;
    }

  
}

