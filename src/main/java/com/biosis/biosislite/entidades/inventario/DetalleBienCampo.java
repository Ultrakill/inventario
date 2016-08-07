package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_bien_campo", schema = "inventario")
public  class DetalleBienCampo implements Serializable {


    @Column(name="id",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(targetEntity=Campo.class)
    @JoinColumn(name="campo_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Campo campo;


    @Column(name="valor")
    @Basic
    private String valor;


    @ManyToOne(targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;

    public DetalleBienCampo(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }

   public Campo getCampo() {
        return this.campo;
    }


  public void setCampo (Campo campo) {
        this.campo = campo;
    }



   public String getValor() {
        return this.valor;
    }


  public void setValor (String valor) {
        this.valor = valor;
    }



   public Bien getBien() {
        return this.bien;
    }


  public void setBien (Bien bien) {
        this.bien = bien;
    }

    @Override
    public String toString() {
        return valor;
    }
  
  

}

