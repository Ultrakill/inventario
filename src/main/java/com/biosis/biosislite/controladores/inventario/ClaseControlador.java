/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Clase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class ClaseControlador extends AbstractControlador<Clase> {

    public ClaseControlador() {
        super(Clase.class);
    }

    public List<Clase> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Clase a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Clase> buscarXIdLazy(int limite, int offset) {
        String jpql = "SELECT a FROM Clase a ORDER BY a.codigo";
        
        return this.getDao().buscar(jpql, null, limite, offset);
    }
}
