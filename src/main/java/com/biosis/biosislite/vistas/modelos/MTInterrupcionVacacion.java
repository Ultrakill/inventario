/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.InterrupcionVacacion;
import com.biosis.biosislite.entidades.Vacacion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.biosis.biosislite.vistas.AsignarVacacion;

/**
 *
 * @author fesquivelc
 */
public class MTInterrupcionVacacion extends ModeloTabla<InterrupcionVacacion> {

    private final DateFormat dfFecha;

    public MTInterrupcionVacacion(List<InterrupcionVacacion> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Inicio de Interrupción", "Fin de Interrupción", "Días interrumpidos", "Motivo"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        InterrupcionVacacion interrupcionVacacion = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dfFecha.format(interrupcionVacacion.getFechaInicio());
            case 1:
                return dfFecha.format(interrupcionVacacion.getFechaFin());
            
            case 2:
                AsignarVacacion metodo = new AsignarVacacion();
                
                return metodo.fechasAlong(interrupcionVacacion.getFechaInicio(), interrupcionVacacion.getFechaFin())+"";
                
            case 3:
                return interrupcionVacacion.getMotivo();
            
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

}
