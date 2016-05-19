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
public class MTPersonGrupo extends ModeloTabla<Empleado>{
     
    public MTPersonGrupo(List<Empleado> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"Nro Documento","Nombre","Apellido Paterno","Apellido Materno"};     
    }
    
    public MTPersonGrupo(List<Empleado> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Empleado empleado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return empleado.getNroDocumento();
            case 1:
                return empleado.getNombre()+" "+empleado.getPaterno()+" "+empleado.getMaterno();
            case 3:
                return empleado.getPaterno();
            case 4:
                return empleado.getMaterno();
                default:
                    return null;
        }
    }
    
}
