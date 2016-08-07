/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores.inventario;


import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.inventario.Inventario;
import com.biosis.biosislite.entidades.inventario.InventarioAmbiente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class InventarioAmbienteControlador extends AbstractControlador<InventarioAmbiente>{
    public InventarioAmbienteControlador() {
        super(InventarioAmbiente.class);
    }
    
    public List<InventarioAmbiente> buscarXInventario(Inventario inventario) {
        String jpql = "SELECT a FROM InventarioAmbiente a WHERE a.inventario = :inventario";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<InventarioAmbiente> buscarXInventarioIncompleto(Inventario inventario) {
        String jpql = "SELECT a FROM InventarioAmbiente a WHERE a.inventario = :inventario AND a.estado = 0";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<InventarioAmbiente> buscarXNombrexInventario(String nombre, Inventario inventario){
        String jpql = "SELECT a FROM InventarioAmbiente a WHERE a.ambiente.nombre LIKE CONCAT('%',:nombre,'%') AND a.inventario = :inventario";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<InventarioAmbiente> buscarXNombreXCodigo(String buscar){
        String jpql = "SELECT a FROM Ambiente a WHERE a.ambiente.nombre LIKE CONCAT('%',:buscar,'%') OR a.ambiente.codigo LIKE CONCAT('%',:buscar,'%')";
        Map<String, Object> parametros = new HashMap<>();       
        parametros.put("buscar", buscar);
        return this.getDao().buscar(jpql, parametros);      
        
    }
    
    public InventarioAmbiente buscarXAmbientexInventario(Departamento ambiente, Inventario inventario){
        String jpql = "SELECT a FROM InventarioAmbiente a WHERE a.ambiente = :ambiente AND a.inventario = :inventario";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ambiente", ambiente);
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros).get(0);
    }
}
