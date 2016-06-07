
package com.biosis.biosislite.entidades;

import com.biosis.biosislite.entidades.escalafon.Ubigeo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Documentos
 */

@Entity
public class Viaje implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "gerencia")
    @Basic
    private String gerencia;
    
    @Column(name = "centro_costo")
    @Basic
    private String centroCosto;    
    
    @Column(name = "dias_alimentacion")
    private long diasAlimentacion;
    
    @Column(name = "dias_alojamiento")
    private long diasAlojamiento;
    
    @Column(name = "dias_movlocal")
    private long diasMovLocal;
    
    
    @Column(name = "alimentacion")
    private double alimentacion;
    
    @Column(name = "alojamiento")
    private double alojamiento;
    
    @Column(name = "movilidad")
    private double movilidad;
    
    @Column(name = "combustible")
    private double combustible;
    
    @OneToOne(targetEntity = Permiso.class)
    @JoinColumn(name="permiso_id",referencedColumnName="id", nullable = true)
    private Permiso permiso;
    
    @OneToOne(targetEntity = Ubigeo.class)
    @JoinColumn(name="ubigeo_viaje",referencedColumnName="codigo")
    private Ubigeo ubigeo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDiasAlimentacion() {
        return diasAlimentacion;
    }

    public void setDiasAlimentacion(long diasAlimentacion) {
        this.diasAlimentacion = diasAlimentacion;
    }

    public long getDiasAlojamiento() {
        return diasAlojamiento;
    }

    public void setDiasAlojamiento(long diasAlojamiento) {
        this.diasAlojamiento = diasAlojamiento;
    }

    public long getDiasMovLocal() {
        return diasMovLocal;
    }

    public void setDiasMovLocal(long diasMovLocal) {
        this.diasMovLocal = diasMovLocal;
    }

    public double getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(double alimentacion) {
        this.alimentacion = alimentacion;
    }

    public double getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(double alojamiento) {
        this.alojamiento = alojamiento;
    }

    public double getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(double movilidad) {
        this.movilidad = movilidad;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }
    
    
    
    
    
}
