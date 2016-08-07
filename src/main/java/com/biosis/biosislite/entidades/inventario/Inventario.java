package com.biosis.biosislite.entidades.inventario;

import com.biosis.biosislite.entidades.Periodo;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="inventario", schema = "inventario")
public  class Inventario implements Serializable {


    @Column(name="estado")
    @Basic
    private boolean estado;
    
    @Column(name="importado")
    @Basic
    private boolean importado;


    @Column(name="fecha_fin")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fecha_fin;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=InventarioAmbiente.class,mappedBy="inventario")
    private List<InventarioAmbiente> inventarioAmbienteList;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien_Inventario.class,mappedBy="inventario")
    private List<Bien_Inventario> bien_InventarioList;


    @Column(name="id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name="nombre")
    @Basic
    private String nombre;


    @ManyToOne(optional = false, targetEntity = Periodo.class)
    @JoinColumn(name = "id_periodo", referencedColumnName = "anio", insertable = true, nullable = false, unique = false, updatable = true)
    private Periodo periodo;


    @Column(name="fecha_inicio")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fecha_inicio;

    public Inventario(){

    }


    public Boolean getEstado() {
        return this.estado;
    }


  public void setEstado (boolean estado) {
        this.estado = estado;
    }



   public Date getFecha_fin() {
        return this.fecha_fin;
    }


  public void setFecha_fin (Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }



   public List<InventarioAmbiente> getInventarioAmbienteList() {
        return this.inventarioAmbienteList;
    }


  public void setInventarioAmbienteList (List<InventarioAmbiente> inventarioAmbienteList) {
        this.inventarioAmbienteList = inventarioAmbienteList;
    }



   public List<Bien_Inventario> getBien_InventarioList() {
        return this.bien_InventarioList;
    }


  public void setBien_InventarioList (List<Bien_Inventario> bien_InventarioList) {
        this.bien_InventarioList = bien_InventarioList;
    }



   public Long getId() {
        return this.Id;
    }


  public void setId (Long Id) {
        this.Id = Id;
    }



   public Periodo getPeriodo() {
        return this.periodo;
    }


  public void setPeriodo (Periodo periodo) {
        this.periodo = periodo;
    }



   public Date getFecha_inicio() {
        return this.fecha_inicio;
    }


  public void setFecha_inicio (Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
  
}

