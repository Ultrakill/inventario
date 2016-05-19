/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.entidades.educativo.SeccionHorario;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class MTSeccionHorario extends ModeloTabla<SeccionHorario>{
    private final DateFormat dfFecha;
    
    public MTSeccionHorario(List<SeccionHorario> datos, String[] nombreColumnas){
        super(datos, nombreColumnas);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
    }
    
    @Override
    public Object getValorEn(int rowIndex, int columnIndex){
        SeccionHorario sh = this.datos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return dfFecha.format(sh.getFechaInicio());
            case 1:
                return dfFecha.format(sh.getFechaFin());
            case 2:
                return sh.getHorario().getCodigo();
            case 3: 
                return sh.getSeccion().getNombre();
            default:
                return null;
        }
    }
}
