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
public class MTAsignarVacacion extends ModeloTabla<Vacacion> {

    private final DateFormat dfFecha;

    public MTAsignarVacacion(List<Vacacion> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Código", "Nro de documento", "Fecha de inicio", "Fecha de fin", "Días", "Interrupcion", "Reprogramacion", "Periodo"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Vacacion vacacion = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vacacion.getEmpleado().getFichaLaboral().getCodigoTrabajador();
            case 1:
                return vacacion.getEmpleado().getNombreCompleto();
            case 2:
                return dfFecha.format(vacacion.getFechaInicio());
            case 3:
                return dfFecha.format(vacacion.getFechaFin());
            case 4:
//                AsignarVacacion metodo = new AsignarVacacion();
//                
                return this.fechasAlong(vacacion.getFechaInicio(), vacacion.getFechaFin())+"";
            case 5:
                InterrupcionVacacion interrupcion = vacacion.getInterrupcionVacacion();
                if (interrupcion != null) {
                    return String.format("INTERRUPCIÓN DESDE %s HASTA %s", dfFecha.format(interrupcion.getFechaInicio()), dfFecha.format(interrupcion.getFechaFin()));
                } else {
                    return "NO";
                }
            case 6:
                Vacacion reprogramacion = vacacion.getVacacionReprogramacion();
                if (reprogramacion != null) {
                    return String.format("REPROGRAMADO DESDE %s AL  %s", dfFecha.format(reprogramacion.getFechaInicio()), dfFecha.format(reprogramacion.getFechaFin()));
                } else {
                    return "NO";
                }
            case 7:
                Date Contrato = vacacion.getEmpleado().getContratoList().get(0).getFechaInicio();
                if (Contrato != null) {
                    Calendar limite = Calendar.getInstance();
                    limite.setTime(Contrato);
                    int diaAnio = limite.get(Calendar.DAY_OF_YEAR);

//                    Date fechaInicio = vacacion.getFechaInicio();
                    int periodo = vacacion.getPeriodo().getAnio();
                    int periodoSig = periodo + 1;

//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(Contrato);
//                    cal.set(Calendar.YEAR, periodo);
//
//                    int diaAnioVac = cal.get(Calendar.DAY_OF_YEAR);
//                    int anio = cal.get(Calendar.YEAR);
//
//                    if (diaAnioVac <= diaAnio) {
//                        int anioAnt = anio - 1;
//
//                        return anioAnt + " - " + anio;
//                        
//                    } else {                       
//                        int anioSig = anio + 1;
                    return periodo + " - " + periodoSig;
//                    }
                }

            default:
                return null;
        }
    }
    
    public long fechasAlong(Date inicio, Date fin) {

        long restaLog = (fin.getTime() - inicio.getTime());
        long resta = (restaLog / (1000 * 60 * 60 * 24)) + 1;
        return resta;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

}
