/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Inventario;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class InventarioControlador extends AbstractControlador<Inventario>{
    
    public InventarioControlador() {
        super(Inventario.class);
    }
    
    public List<Inventario> buscarXFechas(Date inicio, Date fin) {
        String jpql = "SELECT a FROM Inventario a WHERE (:inicio Between a.fecha_inicio AND a.fecha_fin "
                + ") OR ( :fin Between a.fecha_inicio AND a.fecha_fin ) "
                + "ORDER BY a.fecha_inicio DESC ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Inventario> buscarXNombre(String buscar){
        String jpql = "SELECT a FROM Inventario a WHERE a.nombre LIKE CONCAT('%',:buscar,'%')";
        Map<String, Object> parametros = new HashMap<>();       
        parametros.put("buscar", buscar);
        return this.getDao().buscar(jpql, parametros);      
        
    }
}
