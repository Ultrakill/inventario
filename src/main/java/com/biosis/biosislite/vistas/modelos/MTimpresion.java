/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.inventario.BienInventarioControlador;
import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.biosis.biosislite.entidades.inventario.Inventario;
import com.biosis.biosislite.entidades.inventario.InventarioAmbiente;
import com.biosis.biosislite.entidades.inventario.Movimiento;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTimpresion extends ModeloTabla<Bien_Inventario> {

    private final DateFormat dfFecha;
    private BienInventarioControlador bic = new BienInventarioControlador();

    public MTimpresion(List<Bien_Inventario> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Bien/producto", "Estado de impresión"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Bien_Inventario inventario = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventario.getBien().getNombre();
            case 1:
                if (inventario.getImpresionPendiente()) {
                    return "Impresión pendiente";
                } else {
                    return "Impreso";
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
