/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.inventario.Movimiento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTReporteInventario extends ModeloTabla<Bien_Inventario> {

    private final DateFormat dfFecha;

    public MTReporteInventario(List<Bien_Inventario> datos) {
        super(datos);
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");
        this.nombreColumnas = new String[]{"Ambiente", "Bien/Producto", "Código de barra", "Responsable"};
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Bien_Inventario inventario = this.datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventario.getInventarioAmbiente().getAmbiente().getNombre();
            case 1:

                return inventario.getBien().getNombre();
            case 2:
                return inventario.getBien().getCodigo()+inventario.getSerie();

            case 3:

                if (inventario.getEmpleado() == null) {
                    return "NO TIENE";
                } else {
                    return inventario.getEmpleado().getNombreCompleto();
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
