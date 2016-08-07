/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Proveedor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class ProveedorControlador extends AbstractControlador<Proveedor>{

    public ProveedorControlador() {
        super(Proveedor.class);
    }
    
    public List<Proveedor> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Proveedor a WHERE a.nombreProveedor LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
}
