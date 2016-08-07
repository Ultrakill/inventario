package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clase", schema = "inventario")
public  class Clase implements Serializable {


    @Column(nullable=false)
    @Basic
    private String nombre;


    @Column(nullable=false,length=45)
    @Id
    private String codigo;


    @ManyToOne(optional=false,targetEntity=Tipo.class)
    @JoinColumn(name="tipo_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Tipo tipo;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien.class,mappedBy="clase")
    private List<Bien> bienes;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Campo.class,mappedBy="clase")
    private List<Campo> campoList;

    public Clase(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public String getCodigo() {
        return this.codigo;
    }


  public void setCodigo (String codigo) {
        this.codigo = codigo;
    }



   public Tipo getTipo() {
        return this.tipo;
    }


  public void setTipo (Tipo tipo) {
        this.tipo = tipo;
    }



   public List<Bien> getBienes() {
        return this.bienes;
    }


  public void setBienes (List<Bien> bienes) {
        this.bienes = bienes;
    }



   public List<Campo> getCampoList() {
        return this.campoList;
    }


  public void setCampoList (List<Campo> campoList) {
        this.campoList = campoList;
    }

    @Override
    public String toString() {
        return nombre;
    }
  
  

}

