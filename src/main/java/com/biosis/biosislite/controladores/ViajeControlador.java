/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.DetalleJornada;
import com.biosis.biosislite.entidades.InterrupcionVacacion;
import com.biosis.biosislite.entidades.Jornada;
import com.biosis.biosislite.entidades.Permiso;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.Viaje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class ViajeControlador extends Controlador<Viaje>{
    
    public ViajeControlador() {
        super(Viaje.class);
    }
    
    
//    
//    public List<InterrupcionVacacion> buscarXVacacion(Vacacion vacacion){
//        String jpql = "SELECT a FROM InterrupcionVacacion a WHERE a.vacacion = :vacacion";
//        Map<String, Object> map = new HashMap();
//        map.put("vacacion", vacacion);
//        return this.getDao().buscar(jpql, map);
//    }
    
    public Viaje buscarPorPermiso(Permiso permiso) {
        String jpql = "SELECT e FROM Viaje e WHERE e.permiso = :permiso";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("permiso", permiso);

        List<Viaje> viaje = this.getDao().buscar(jpql, mapa);
        if (viaje.isEmpty()) {
            return null;
        } else {
            return viaje.get(0);
        }
    }
}
