/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.escalafon.UnidadNegocio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class UnidadNegocioControlador extends Controlador<UnidadNegocio> {

    public UnidadNegocioControlador() {
        super(UnidadNegocio.class);
    }

    public List<UnidadNegocio> buscarXDescripcion(String patron) {
        String jpql = "SELECT n FROM UnidadNegocio n WHERE n.nombre LIKE CONCAT('%',:patron,'%')";
        Map<String, Object> map = new HashMap();
        map.put("patron", patron.trim().toUpperCase());
        return this.getDao().buscar(jpql, map);
    }
}
