/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.ConceptoControlador;
import com.biosis.biosislite.controladores.GradoControlador;
import com.biosis.biosislite.controladores.NivelControlador;
import com.biosis.biosislite.controladores.SeccionControlador;
import com.biosis.biosislite.entidades.educativo.AsignacionNGS;
import com.personal.utiles.ModeloTabla;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class MTAsignacionNGS extends ModeloTabla<AsignacionNGS>{
    ConceptoControlador cc = ConceptoControlador.getInstance();
    NivelControlador nc = new NivelControlador();
    GradoControlador gc = new GradoControlador();
    SeccionControlador sc = new SeccionControlador();
    
    public MTAsignacionNGS(List<AsignacionNGS> datos){
        super(datos);
        this.nombreColumnas = new String[]{"Responsable","Rol","Fecha Inicio","Fecha Fin"};   
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex){
        AsignacionNGS asignacion = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return asignacion.getResponsable().getNombre()+" "
                        +asignacion.getResponsable().getPaterno()+" "
                        +asignacion.getResponsable().getMaterno();
            case 1:
                return cc.buscarXPrefijoXCorrelativo(15, asignacion.getTipo()).getDescripcion();
            case 2:
                return asignacion.getFechaInicio().toString();
            case 3:
                return asignacion.getFechaFin().toString();
            default:
                return null;
        }
    }
}
