package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Basic;
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

@Entity
@Table(name="campo", schema = "inventario")
public  class Campo implements Serializable {


    @Column(name="nombre")
    @Basic
    private String nombre;


    @Column(name="id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=DetalleBienCampo.class,mappedBy="campo")
    private List<DetalleBienCampo> detalleBienCampoList;


    @ManyToOne(targetEntity=Clase.class)
    @JoinColumn(name="clase_codigo",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private Clase clase;


    @Column(name="modificable")
    @Basic
    private Boolean modificable;

    public Campo(){

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



   public List<DetalleBienCampo> getDetalleBienCampoList() {
        return this.detalleBienCampoList;
    }


  public void setDetalleBienCampoList (List<DetalleBienCampo> detalleBienCampoList) {
        this.detalleBienCampoList = detalleBienCampoList;
    }



   public Clase getClase() {
        return this.clase;
    }


  public void setClase (Clase clase) {
        this.clase = clase;
    }



    public Boolean isModificable() {
        return this.modificable;
    }


  public void setModificable (Boolean modificable) {
        this.modificable = modificable;
    }

    @Override
    public String toString() {
        return nombre;
    }

  
}

