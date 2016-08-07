/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.biosis.biosislite.entidades.inventario.Movimiento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class MovimientoControlador extends AbstractControlador<Movimiento>{

    public MovimientoControlador() {
        super(Movimiento.class);
    }
    
    public List<Movimiento> buscarXBien(Bien_Inventario inventario) {
        String jpql = "SELECT a FROM Movimiento a WHERE a.inventario = :inventario ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
}
