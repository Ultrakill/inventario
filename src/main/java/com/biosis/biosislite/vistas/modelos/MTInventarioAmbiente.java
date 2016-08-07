/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

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
public class MTInventarioAmbiente extends ModeloTabla<InventarioAmbiente> {

    private final DateFormat dfFecha;

    public MTInventarioAmbiente(List<InventarioAmbiente> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Inventario", "Ambiente", "Estado"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        InventarioAmbiente ambiente = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ambiente.getInventario().getNombre();
            case 1:
                return ambiente.getAmbiente().getNombre();
            case 2:

                if (ambiente.isEstado()) {
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
