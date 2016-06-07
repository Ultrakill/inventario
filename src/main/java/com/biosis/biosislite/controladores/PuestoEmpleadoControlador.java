/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.escalafon.Contrato;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.escalafon.PuestoEmpleado;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RyuujiMD
 */
public class PuestoEmpleadoControlador extends Controlador<PuestoEmpleado> {

    private PuestoEmpleadoControlador() {
        super(PuestoEmpleado.class);
    }

    public static PuestoEmpleadoControlador getInstance() {
        return PuestoEmpleadoControladorHolder.INSTANCE;
    }

    private static class PuestoEmpleadoControladorHolder {

        private static final PuestoEmpleadoControlador INSTANCE = new PuestoEmpleadoControlador();
    }


    public List<PuestoEmpleado> buscarXNombrexFechaASC(Empleado empleado) {
        String jpql = "SELECT c FROM PuestoEmpleado c WHERE c.empleado = :empleado "
                + " ORDER BY c.fechaInicio ASC";

        Map<String, Object> param = new HashMap<>();
        param.put("empleado", empleado);

        return this.getDao().buscar(jpql, param);
    }
}
