/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.escalafon;

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
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Documentos
 */
@Entity
@Table(name ="Gerencia", schema = "personal")
public class Gerencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    @Basic
    private String nombre;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = AreaEmpleado.class,mappedBy = "gerencia")
    private List<AreaEmpleado> areaEmpleadoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AreaEmpleado> getAreaEmpleadoList() {
        return areaEmpleadoList;
    }

    public void setAreaEmpleadoList(List<AreaEmpleado> areaEmpleadoList) {
        this.areaEmpleadoList = areaEmpleadoList;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
}
