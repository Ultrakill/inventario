package com.biosis.biosislite.entidades.inventario;

import com.biosis.biosislite.entidades.escalafon.Departamento;
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
@Table(name="inventario_ambiente", schema = "inventario")
public  class InventarioAmbiente implements Serializable {


    @Column(name="id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="estado")
    @Basic
    private boolean estado;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien_Inventario.class,mappedBy="inventarioAmbiente")
    private List<Bien_Inventario> bien_InventarioList;


    @ManyToOne(targetEntity=Departamento.class)
    @JoinColumn(name="id_ambiente",referencedColumnName="area_id")
    private Departamento ambiente;


    @ManyToOne(targetEntity=Inventario.class)
    @JoinColumn(name="id_inventario",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Inventario inventario;

    public InventarioAmbiente(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



    public boolean isEstado() {
        return this.estado;
    }


  public void setEstado (boolean estado) {
        this.estado = estado;
    }



   public List<Bien_Inventario> getBien_InventarioList() {
        return this.bien_InventarioList;
    }


  public void setBien_InventarioList (List<Bien_Inventario> bien_InventarioList) {
        this.bien_InventarioList = bien_InventarioList;
    }



   public Departamento getAmbiente() {
        return this.ambiente;
    }


  public void setAmbiente (Departamento ambiente) {
        this.ambiente = ambiente;
    }



   public Inventario getInventario() {
        return this.inventario;
    }


  public void setInventario (Inventario inventario) {
        this.inventario = inventario;
    }

}

