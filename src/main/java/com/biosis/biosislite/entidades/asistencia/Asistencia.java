/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.entidades.asistencia;

import com.biosis.biosislite.entidades.Feriado;
import com.biosis.biosislite.entidades.Marcacion;
import com.biosis.biosislite.entidades.Permiso;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.sisgedo.Boleta;
import java.util.Date;
import java.util.List;
import com.biosis.biosislite.utiles.HerramientaGeneral;

/**
 *
 * @author Francis
 */
public class Asistencia {

    private Empleado empleado;
    private List<DetalleAsistencia> detalleAsistenciaList;
    private Date fecha;
    private List<DetalleAsistencia> permisoList;
    private int resultado;
    private Permiso permiso;
    private Vacacion vacacion;
    private Feriado feriado;
    private boolean permisoConGoce;
    private Boleta boleta;
    private List<Marcacion> marcacionesFuera;
    private String marcacionesFueraStr;

    public List<Marcacion> getMarcacionesFuera() {
        return marcacionesFuera;
    }

    public void setMarcacionesFuera(List<Marcacion> marcacionesFuera) {
        this.marcacionesFuera = marcacionesFuera;
        StringBuilder sb = new StringBuilder();        
        marcacionesFuera.stream().forEach((Marcacion m) -> {
            sb.append(HerramientaGeneral.formatoHoraMinuto.format(m.getFechaHora()));
            sb.append(" ");
        });
        this.marcacionesFueraStr = sb.toString();
    }

    public String getMarcacionesFueraStr() {
        return marcacionesFueraStr;
    }

//    public void setMarcacionesFueraStr(String marcacionesFueraStr) {
//        this.marcacionesFueraStr = marcacionesFueraStr;
//    }
    

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public boolean isPermisoConGoce() {
        return permisoConGoce;
    }

    public void setPermisoConGoce(boolean permisoConGoce) {
        this.permisoConGoce = permisoConGoce;
    }

    public Feriado getFeriado() {
        return feriado;
    }

    public void setFeriado(Feriado feriado) {
        this.feriado = feriado;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Vacacion getVacacion() {
        return vacacion;
    }

    public void setVacacion(Vacacion vacacion) {
        this.vacacion = vacacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<DetalleAsistencia> getDetalleAsistenciaList() {
        return detalleAsistenciaList;
    }

    public void setDetalleAsistenciaList(List<DetalleAsistencia> detalleAsistenciaList) {
        this.detalleAsistenciaList = detalleAsistenciaList;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleAsistencia> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<DetalleAsistencia> permisoList) {
        this.permisoList = permisoList;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
