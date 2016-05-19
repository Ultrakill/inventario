/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.ConceptoControlador;
import com.biosis.biosislite.entidades.Concepto;
import com.personal.utiles.ModeloTabla;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class MTConcepto extends ModeloTabla<Concepto>{
    
    ConceptoControlador cc = ConceptoControlador.getInstance();

    public MTConcepto(List<Concepto> datos){
        super(datos);
        this.nombreColumnas = new String[]{"Descripción"};
    }    
    
    public MTConcepto(List<Concepto> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
    }
    
    @Override
    public Object getValorEn(int rowIndex,int columnIndex){
        Concepto concepto = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return concepto.getDescripcion();
            case 1:
                return concepto.getEstado();
            default:
                return null;
        }
    }
}
