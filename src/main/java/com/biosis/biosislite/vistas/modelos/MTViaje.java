/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.ViajeControlador;
import com.biosis.biosislite.entidades.AsignacionPermiso;
import com.biosis.biosislite.entidades.Viaje;
import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTViaje extends ModeloTabla<AsignacionPermiso>{

    public MTViaje(List<AsignacionPermiso> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"SAP", "Destino", "Duración(en días)", "Monto total"};
        
    }
    
    public MTViaje(List<AsignacionPermiso> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
    }

    private ViajeControlador vsc = new ViajeControlador();
    
    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        
        AsignacionPermiso viaje = this.datos.get(rowIndex);
        
        Viaje viajes = vsc.buscarPorPermiso(viaje.getPermiso());
        
        switch(columnIndex){
            case 0:
                return viaje.getEmpleado().getFichaLaboral().getCodigoTrabajador();
            case 1:                
                return viajes.getDestino();
            case 2:
                return fechasAlong(viaje.getPermiso().getFechaInicio(), viaje.getPermiso().getFechaFin());
            case 3:
                
                double total = (viajes.getAlimentacion() * viajes.getDiasAlimentacion()) + (viajes.getAlojamiento() * viajes.getDiasAlojamiento()) + (viajes.getMovilidad() * viajes.getDiasMovLocal()) + viajes.getCombustible();
                return total;
//            case 4:
//                return empleado.getMaterno();
                default:
                    return null;
        }
    }
    
    public long fechasAlong(Date inicio, Date fin) {

        long restaLog = (fin.getTime() - inicio.getTime());
        long resta = (restaLog / (1000 * 60 * 60 * 24)) + 1;
        return resta;
    }
  
}