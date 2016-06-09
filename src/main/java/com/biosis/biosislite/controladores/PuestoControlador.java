/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.escalafon.Nacionalidad;
import com.biosis.biosislite.entidades.escalafon.Puesto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class PuestoControlador extends Controlador<Puesto>{
    
    private PuestoControlador() {
        super(Puesto.class);
    }
    
    public List<Puesto> buscarXDescripcion(String patron){
        String jpql = "SELECT n FROM Puesto n WHERE n.nombre LIKE CONCAT('%',:patron,'%')";
        Map<String, Object> map = new HashMap();
        map.put("patron", patron.trim().toUpperCase());
        return this.getDao().buscar(jpql, map);
    }
    
    public static PuestoControlador getInstance() {
        return PuestoControladorHolder.INSTANCE;
    }
    
    private static class PuestoControladorHolder {

        private static final PuestoControlador INSTANCE = new PuestoControlador();
    }
}
