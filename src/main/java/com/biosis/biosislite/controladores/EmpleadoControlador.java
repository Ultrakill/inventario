/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.escalafon.Contrato;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.escalafon.FichaGeneral;
import com.biosis.biosislite.entidades.escalafon.FichaLaboral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class EmpleadoControlador extends Controlador<Empleado> {

    public EmpleadoControlador() {
        super(Empleado.class);
    }

    @Override
    public void prepararCrear() {
        super.prepararCrear(); //To change body of generated methods, choose Tools | Templates.
        FichaLaboral fichaLaboral = new FichaLaboral();
        fichaLaboral.setEmpleado(this.getSeleccionado());
        
        FichaGeneral fichaGeneral = new FichaGeneral();
        fichaGeneral.setEmpleado(this.getSeleccionado());
        
        this.getSeleccionado().setContratoList(new ArrayList<Contrato>());
        this.getSeleccionado().setFichaLaboral(fichaLaboral);
        this.getSeleccionado().setFichaGeneral(fichaGeneral);
        
    }
    
    

    public List<Empleado> buscarXPatron(String patron) {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "UPPER(CONCAT(nombre,paterno,materno)) LIKE CONCAT('%',UPPER(:patron),'%') OR e.nroDocumento = UPPER(:patron) "
                + "ORDER BY e.paterno,e.materno,e.nombre";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("patron", patron);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<Empleado> buscarXPatron(String patron, int desde, int tamanio) {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "(UPPER(CONCAT(nombre,paterno,materno)) LIKE CONCAT('%',UPPER(:patron),'%') OR e.nroDocumento = UPPER(:patron) OR e.fichaLaboral.codigoTrabajador = UPPER(:patron))"
                + "  ORDER BY e.paterno,e.materno,e.nombre";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("patron", patron);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }
    
    public List<Empleado> buscarXPatronBaja(String patron, int desde, int tamanio) {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "(UPPER(CONCAT(nombre,paterno,materno)) LIKE CONCAT('%',UPPER(:patron),'%') OR e.nroDocumento = UPPER(:patron) OR e.fichaLaboral.codigoTrabajador = UPPER(:patron))"
                + " AND e.baja = 0 ORDER BY e.paterno,e.materno,e.nombre";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("patron", patron);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }
    
//    public List<Empleado> buscarXPatronBajaArea(String patron, int desde, int tamanio, Departamento area) {
//        String jpql = "SELECT e FROM Empleado e WHERE "
//                + "(UPPER(CONCAT(nombre,paterno,materno)) LIKE CONCAT('%',UPPER(:patron),'%') OR e.nroDocumento = UPPER(:patron) OR e.fichaLaboral.codigoTrabajador = UPPER(:patron))"
//                + " AND e.baja = 0  ORDER BY e.paterno,e.materno,e.nombre";
//        Map<String, Object> mapa = new HashMap<>();
//        mapa.put("patron", patron);
//        mapa.put("area", area);
//        return this.getDao().buscar(jpql, mapa, desde, tamanio);
//    }
    
    public int totalXPatron(String patron){
        String jpql = "SELECT COUNT(e.nroDocumento) FROM Empleado e WHERE "
                + "UPPER(CONCAT(e.nombre,' ',e.paterno,' ',e.materno)) LIKE CONCAT('%',UPPER(:patron),'%') OR e.nroDocumento = UPPER(:patron)  OR e.fichaLaboral.codigoTrabajador = UPPER(:patron)";
        Long cont = (Long)this.getDao().getEntityManager().createQuery(jpql)
                .setParameter("patron", patron).getSingleResult();
        int conteo = cont.intValue();
        return conteo;
    }

    public List<Empleado> buscarPorLista(List<String> lista) {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "e.nroDocumento IN :lista";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("lista", lista);
        return this.getDao().buscar(jpql, mapa);
    }
    
    

    public Empleado buscarPorId(int id) {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "CAST(e.nroDocumento AS integer) = :id ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("id", id);

        List<Empleado> empleados = this.getDao().buscar(jpql, mapa, -1, 1);
        if (empleados.isEmpty()) {
            return null;
        } else {
            return empleados.get(0);
        }
    }
    
    public Empleado buscarPorCodigoSAP(String sap) {
        String jpql = "SELECT e FROM Empleado e WHERE e.fichaLaboral.codigoTrabajador = :sap";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("sap", sap);

        List<Empleado> empleados = this.getDao().buscar(jpql, mapa);
        if (empleados.isEmpty()) {
            return null;
        } else {
            return empleados.get(0);
        }
    }
    
    public List<Empleado> buscarPorBaja() {
        String jpql = "SELECT e FROM Empleado e WHERE "
                + "e.baja = 0";
        Map<String, Object> mapa = new HashMap<>();
        return this.getDao().buscar(jpql, mapa);
    }

}
