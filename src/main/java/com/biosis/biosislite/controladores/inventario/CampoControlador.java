/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.inventario.Campo;
import com.biosis.biosislite.entidades.inventario.Clase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class CampoControlador extends AbstractControlador<Campo>{
    public CampoControlador(){
        super(Campo.class);
    }
    
    public List<Campo> buscarXClase(Clase clase) {
        String jpql = "SELECT a FROM Campo a WHERE a.clase = :clase";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clase", clase);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Campo> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Campo a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Campo> buscarXClaseXModificable(Clase clase) {
        String jpql = "SELECT a FROM Campo a WHERE a.clase = :clase AND a.modificable = true";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clase", clase);
        return this.getDao().buscar(jpql, parametros);
    }
}
