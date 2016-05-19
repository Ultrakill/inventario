/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.reportes;

import com.biosis.biosislite.algoritmo.AnalizadorAsistencia;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.entidades.asistencia.Asistencia;
import com.biosis.biosislite.entidades.asistencia.DetalleAsistencia;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class testAnalizador {
    public static void main(String[] args) {
        EmpleadoControlador ec = new EmpleadoControlador();
        AnalizadorAsistencia analizador = new AnalizadorAsistencia();
        List<Empleado> listaEmpleados = ec.buscarXPatron("60985529");
        List<Asistencia> listaAsistencia = analizador.analizarAsistencia(listaEmpleados, new Date(1460962881), new Date(1461308481));
        for(Asistencia a : listaAsistencia){
            System.out.println("Alumna: "+a.getEmpleado().getNombre()+" "+a.getEmpleado().getPaterno());
            System.out.println("Fecha: "+a.getFecha().toString());
            System.out.println("Resultado: "+a.getResultado());
            List<DetalleAsistencia> detalleList =  a.getDetalleAsistenciaList();
            
            if(detalleList!=null){
                for(DetalleAsistencia da : detalleList){
                    System.out.println("Hora evento "+da.getHoraEvento().toString());
                    System.out.println("Tipo evento: "+da.getTipo());
                }
            }
        }
    }
}
