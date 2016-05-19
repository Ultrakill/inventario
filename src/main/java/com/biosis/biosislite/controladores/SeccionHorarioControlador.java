/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.educativo.Seccion;
import com.biosis.biosislite.entidades.educativo.SeccionHorario;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aldo
 */
public class SeccionHorarioControlador extends Controlador<SeccionHorario>{
    
    public SeccionHorarioControlador(){
        super(SeccionHorario.class);
    }
    
    public List<SeccionHorario> buscarXFechas(Seccion seccion,Date fechaParaBuscar){
        String jpql = "SELECT sh FROM SeccionHorario sh WHERE sh.seccion = :seccion AND :fechaParaBuscar BETWEEN sh.fechaInicio AND sh.fechaFin ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("seccion", seccion);
        mapa.put("fechaParaBuscar", fechaParaBuscar);
        return this.getDao().buscar(jpql, mapa);
    }
}
