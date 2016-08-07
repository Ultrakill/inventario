/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.entidades.inventario.Inventario;
import com.biosis.biosislite.entidades.inventario.InventarioAmbiente;
import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.inventario.Movimiento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTInventario extends ModeloTabla<Inventario> {

    private final DateFormat dfFecha;

    public MTInventario(List<Inventario> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Nombre", "Periodo", "Fecha Inicio", "Fecha fin", "Estado"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Inventario inventario = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventario.getNombre();
            case 1:
                return inventario.getPeriodo();
            case 2:
                return dfFecha.format(inventario.getFecha_inicio());
            case 3:
                return dfFecha.format(inventario.getFecha_fin());
            case 4:
                if (inventario.getEstado()) {
                    return "COMPLETO";
                } else {
                    return "INCOMPLETO";
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
