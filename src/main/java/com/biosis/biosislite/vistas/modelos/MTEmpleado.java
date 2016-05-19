/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.ConceptoControlador;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.personal.utiles.ModeloTabla;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTEmpleado extends ModeloTabla<Empleado>{
    
    ConceptoControlador cc = ConceptoControlador.getInstance();
    
    public MTEmpleado(List<Empleado> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"Nro Documento","Tipo de Documento","Nombre","Apellido Paterno","Apellido Materno"};     
    }
    
    public MTEmpleado(List<Empleado> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Empleado empleado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return empleado.getNroDocumento();
            case 1:
                return cc.buscarXPrefijoXCorrelativo(10, empleado.getCodigoTipoDocumento()).getAbreviatura();
            case 2:
                return empleado.getNombre();
            case 3:
                return empleado.getPaterno();
            case 4:
                return empleado.getMaterno();
                default:
                    return null;
        }
    }
    
}
