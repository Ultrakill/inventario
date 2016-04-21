/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.Concepto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aldo
 */
public class ConceptoControlador extends Controlador<Concepto>{
    
    private ConceptoControlador() {
        super(Concepto.class);
    }
    
    public static ConceptoControlador getInstance() {
        return ConceptoControladorHolder.INSTANCE;
    }
    
    private static class ConceptoControladorHolder {

        private static final ConceptoControlador INSTANCE = new ConceptoControlador();
    }
    
    public List<Concepto> buscarXPrefijo(Integer prefijo){
        String jpql = "SELECT c FROM Concepto c WHERE c.id.prefijo = :prefijo";
        Map<String,Object> mapa = new HashMap<>(); 
        mapa.put("prefijo",prefijo);
        return this.getDao().buscar(jpql, mapa);
    }
    
    
}
