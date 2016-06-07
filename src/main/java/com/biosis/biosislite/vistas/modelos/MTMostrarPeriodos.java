/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.controladores.VacacionControlador;
import com.biosis.biosislite.entidades.InterrupcionVacacion;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTMostrarPeriodos extends ModeloTabla<String[]> {

    private final DateFormat dfFecha;

    public MTMostrarPeriodos(List<String[]> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Código", "Nombre Completo", "Periodo", "Dias utilizados", "Dias disponibles"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        String[] lista = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return lista[0];
            case 1:
                return lista[1];
            case 2:
                return lista[2];
            case 3:
                return lista[3];
            case 4:
                return lista[4];
//            case 5:

//            case 6:
//                Date Contrato = vacacion.getEmpleado().getContratoList().get(0).getFechaInicio();
//                if (Contrato != null) {
//                    Calendar limite = Calendar.getInstance();
//                    limite.setTime(Contrato);
//                    int diaAnio = limite.get(Calendar.DAY_OF_YEAR);
//
//                    Date fechaInicio = vacacion.getFechaInicio();
//
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(fechaInicio);
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
//
//                        return anio + " - " + anioSig;
//                    }
//                }
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex
    ) {
        return Object.class;
    }

}
