/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.Periodo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class PeriodoControlador extends Controlador<Periodo>{

    public PeriodoControlador() {
        super(Periodo.class);
    }

    public List<Periodo> buscarTodosOrden() {
        String jpql = "SELECT p FROM Periodo p ORDER BY p.anio DESC";
        return this.getDao().buscar(jpql);
    }
    
    public List<Periodo> buscarPeriodoxAnio(int periodo){
        String jpql = "SELECT p FROM Periodo p WHERE p.anio = :periodo";
        
        Map<String, Object> variables = new HashMap();
        variables.put("periodo", periodo);
        
        return this.getDao().buscar(jpql, variables);
    }
    
}
