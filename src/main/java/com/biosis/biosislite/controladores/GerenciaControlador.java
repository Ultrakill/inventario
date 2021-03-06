/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;


import com.biosis.biosislite.entidades.escalafon.Gerencia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author fesquivelc
 */
public class GerenciaControlador extends Controlador<Gerencia>{
    
    public GerenciaControlador() {
        super(Gerencia.class);
    }
    
    
//    
//    public List<InterrupcionVacacion> buscarXVacacion(Vacacion vacacion){
//        String jpql = "SELECT a FROM InterrupcionVacacion a WHERE a.vacacion = :vacacion";
//        Map<String, Object> map = new HashMap();
//        map.put("vacacion", vacacion);
//        return this.getDao().buscar(jpql, map);
//    }
    
//    public Gerencia buscarPorPermiso(Permiso permiso) {
//        String jpql = "SELECT e FROM Viaje e WHERE e.permiso = :permiso";
//        Map<String, Object> mapa = new HashMap<>();
//        mapa.put("permiso", permiso);
//
//        List<Viaje> viaje = this.getDao().buscar(jpql, mapa);
//        if (viaje.isEmpty()) {
//            return null;
//        } else {
//            return viaje.get(0);
//        }
//    }
    
    public List<Gerencia> buscarXDescripcion(String patron){
        String jpql = "SELECT n FROM Gerencia n WHERE n.nombre LIKE CONCAT('%',:patron,'%')";
        Map<String, Object> map = new HashMap();
        map.put("patron", patron.trim().toUpperCase());
        return this.getDao().buscar(jpql, map);
    }
}
