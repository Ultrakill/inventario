package com.biosis.biosislite.entidades.inventario;

import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
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
@Table(name = "Bien_inventario", schema = "inventario")
public class Bien_Inventario implements Serializable {

    @Column(name = "codigo_fabrica")
    @Basic
    private String codigoFabrica;

    @ManyToOne(targetEntity = Factura.class)
    @JoinColumn(name = "factura_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Factura factura;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaIngreso;

    @ManyToOne(targetEntity = Inventario.class)
    @JoinColumn(name = "id_inventario", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Inventario inventario;

    @ManyToOne(optional = false, targetEntity = Bien.class)
    @JoinColumn(name = "bien_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Bien bien;

    
    @Column(name = "baja")
    @Basic
    private boolean baja;

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serie")
    @Basic
    private String serie;

    @Column(name = "estado")
    @Basic
    private String estado;

    @Column(name = "precio")
    @Basic
    private Double precio;
    
    @Column(name="descripcion")
    @Basic
    private String descripcion;

    @ManyToOne(targetEntity = InventarioAmbiente.class)
    @JoinColumn(name = "id_inventarioambiente", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private InventarioAmbiente inventarioAmbiente;

    @Column(name = "impresion_pendiente")
    @Basic
    private Boolean impresionPendiente;
    
    @Column(name = "entregado")
    @Basic
    private Boolean entregado;

    @ManyToOne(targetEntity = Proveedor.class)
    private Proveedor proveedor;
    
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "id_empleado", referencedColumnName = "nro_documento")
    private Empleado empleado;
    
//    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleBienCampo.class, mappedBy = "bien")
//    private List<DetalleBienCampo> detalleBienCampoList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleMovimiento.class, mappedBy = "inventario")
    private List<DetalleMovimiento> detalleMovimientos;
    
    //UBICACION ESPECIFICA
    @Column(name = "zona")
    @Basic
    private String zona;
    
    @Column(name = "estante")
    @Basic
    private String estante;
    
    @Column(name = "columna")
    @Basic
    private String columna;
    
    @Column(name = "fila")
    @Basic
    private String fila;
    
    @Column(name = "altura")
    @Basic
    private String altura;
    
    
    

    public Bien_Inventario() {

    }


//    public List<DetalleBienCampo> getDetalleBienCampoList() {
//        return detalleBienCampoList;
//    }
//
//    public void setDetalleBienCampoList(List<DetalleBienCampo> detalleBienCampoList) {
//        this.detalleBienCampoList = detalleBienCampoList;
//    }

    
    
//    public String getFoto() {
//        return foto;
//    }
//
//    public void setFoto(String foto) {
//        this.foto = foto;
//    }

    public String getCodigoFabrica() {
        return this.codigoFabrica;
    }

    public void setCodigoFabrica(String codigoFabrica) {
        this.codigoFabrica = codigoFabrica;
    }

    
    
    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Bien getBien() {
        return this.bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public boolean isBaja() {
        return this.baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public InventarioAmbiente getInventarioAmbiente() {
        return this.inventarioAmbiente;
    }

    public void setInventarioAmbiente(InventarioAmbiente inventarioAmbiente) {
        this.inventarioAmbiente = inventarioAmbiente;
    }

    public Boolean getImpresionPendiente() {
        return this.impresionPendiente;
    }

    public void setImpresionPendiente(Boolean impresionPendiente) {
        this.impresionPendiente = impresionPendiente;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleMovimiento> getDetalleMovimientos() {
        return this.detalleMovimientos;
    }

    public void setDetalleMovimientos(List<DetalleMovimiento> detalleMovimientos) {
        this.detalleMovimientos = detalleMovimientos;
    }
//
//    public boolean isBaja() {
//        return baja;
//    }

//    public void setBaja(boolean baja) {
//        this.baja = baja;
//    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    
}
