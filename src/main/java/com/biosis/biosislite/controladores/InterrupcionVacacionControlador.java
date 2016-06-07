/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.DetalleJornada;
import com.biosis.biosislite.entidades.InterrupcionVacacion;
import com.biosis.biosislite.entidades.Jornada;
import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class InterrupcionVacacionControlador extends Controlador<InterrupcionVacacion>{
    
    public InterrupcionVacacionControlador() {
        super(InterrupcionVacacion.class);
    }
    
    
    
    public List<InterrupcionVacacion> buscarXVacacion(Vacacion vacacion){
        String jpql = "SELECT a FROM InterrupcionVacacion a WHERE a.vacacion = :vacacion";
        Map<String, Object> map = new HashMap();
        map.put("vacacion", vacacion);
        return this.getDao().buscar(jpql, map);
    }
    
    public List<InterrupcionVacacion> buscarInterrupcionXEmpleadoXPeriodo(Empleado empleado, Periodo periodo) {
        String jpql = "SELECT v FROM InterrupcionVacacion v"
                + " WHERE v.empleado = :empleado  AND v.periodo = :periodo";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        mapa.put("periodo", periodo);
        return this.getDao().buscar(jpql, mapa);
    }
}
