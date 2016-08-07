/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Factura;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class FacturaControlador extends AbstractControlador<Factura>{
    public FacturaControlador(){
        super(Factura.class);
    }
    
    public List<Factura> buscarXNumero(String numero){
        String jpql = "SELECT a FROM Factura a WHERE a.numeroFactura = :numero";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("numero", numero);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Factura> buscarXFecha(Date inicio, Date fin){
        String jpql = "SELECT a FROM Factura a WHERE a.fecha BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }
    
    
}
