/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.InterrupcionVacacion;
import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class InterrupcionControlador extends Controlador<InterrupcionVacacion>{

    public InterrupcionControlador() {
        super(InterrupcionVacacion.class);
    }
    
    public List<InterrupcionVacacion> buscarInterrupcion(Vacacion vacacion) {
        String jpql = "SELECT v FROM InterrupcionVacacion v"
                + " WHERE v.vacacion = :vacacion";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("vacacion", vacacion);
        return this.getDao().buscar(jpql, mapa);
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
