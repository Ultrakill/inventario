/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.inventario.Movimiento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTTraza extends ModeloTabla<Movimiento> {

    private final DateFormat dfFecha;

    public MTTraza(List<Movimiento> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Fecha de movimiento", "Ubicación Anterior", "Ubicación Destino", "Ubicacion Actual"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Movimiento movimiento = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                    return dfFecha.format(movimiento.getFecha());
            case 1:

                if (movimiento.getAmbienteOrigen() == null) {

                    return "NO TIENE";
                } else {
                    return movimiento.getAmbienteOrigen().getNombre();
                }
            case 2:
                if (movimiento.getAmbienteDestino() == null) {
                    return "NO TIENE";
                } else {
                    return movimiento.getAmbienteDestino().getNombre();
                }
            
            case 3:

                if (movimiento.getInventario().getInventarioAmbiente().getAmbiente() == null) {
                    return "NO TIENE";
                } else {
                    return movimiento.getInventario().getInventarioAmbiente().getAmbiente().getNombre();
                }

            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

}
