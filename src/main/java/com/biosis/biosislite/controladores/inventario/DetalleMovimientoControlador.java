/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.biosis.biosislite.entidades.inventario.DetalleMovimiento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class DetalleMovimientoControlador extends AbstractControlador<DetalleMovimiento>{

    public DetalleMovimientoControlador() {
        super(DetalleMovimiento.class);
    }
    
    
    public List<DetalleMovimiento> buscarXBien(Bien_Inventario inventario) {
        String jpql = "SELECT a FROM DetalleMovimiento a WHERE a.inventario = :inventario ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
}
