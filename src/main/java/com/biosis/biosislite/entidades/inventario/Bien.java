package com.biosis.biosislite.entidades.inventario;

import java.io.Serializable;

import java.lang.String;
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
@Table(name = "bien", schema = "inventario")
public class Bien implements Serializable {

    @Column(name = "nombre", table = "bien")
    @Basic
    private String nombre;

    @Column(name = "id", table = "bien", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foto")
    @Basic
    private String foto;
    
    @Column(name = "codigo")
    @Basic
    private String codigo;
    
    @Column(name = "stock_minimo")
    @Basic
    private int stockMinimo;
    
    @Column(name = "stock_maximo")
    @Basic
    private int stockMaximo;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleBienCampo.class, mappedBy = "bien")
    private List<DetalleBienCampo> detalleBienCampoList;

    @Column(name = "descripcion", table = "bien")
    @Basic
    private String descripcion;

    @ManyToOne(optional = false, targetEntity = Clase.class)
    @JoinColumn(name = "clase_codigo", referencedColumnName = "codigo", insertable = true, nullable = true, unique = false, updatable = true)
    private Clase clase;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Bien_Inventario.class, mappedBy = "bien")
    private List<Bien_Inventario> inventarios;

    public Bien() {

    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetalleBienCampo> getDetalleBienCampoList() {
        return this.detalleBienCampoList;
    }

    public void setDetalleBienCampoList(List<DetalleBienCampo> detalleBienCampoList) {
        this.detalleBienCampoList = detalleBienCampoList;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//   public Clase getClase() {
//        return this.clase;
//    }
//
//
//  public void setClase (Clase clase) {
//        this.clase = clase;
//    }
//
//
//
//   public String getFoto() {
//        return this.foto;
//    }
//
//
//  public void setFoto (String foto) {
//        this.foto = foto;
//    }
    public List<Bien_Inventario> getInventarios() {
        return this.inventarios;
    }

    public void setInventarios(List<Bien_Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    @Override
    public String toString() {
        return nombre;
    }

}
