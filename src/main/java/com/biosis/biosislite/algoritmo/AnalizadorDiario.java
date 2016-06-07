/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.algoritmo;

import com.personal.utiles.FechaUtil;
import com.biosis.biosislite.entidades.Marcacion;
import com.biosis.biosislite.entidades.asistencia.Asistencia;
import com.biosis.biosislite.entidades.asistencia.DetalleAsistencia;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 *
 * @author Francis
 */
public class AnalizadorDiario {
    private int posicion;
    private Asistencia asistencia;
    private List<Marcacion> marcaciones;
    private List<DetalleAsistencia> permisos;
    private final int INICIO = 0;
    private int FIN;
    private final Calendar calendar = Calendar.getInstance();
    private List<Marcacion> marcacionesFuera;
    private final int LIMITE_HORA = 3;

    public List<DetalleAsistencia> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<DetalleAsistencia> permisos) {
        this.permisos = permisos;
    }

    public void setMarcaciones(List<Marcacion> marcaciones) {
        this.marcaciones = marcaciones;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.FIN = asistencia.getDetalleAsistenciaList().size() - 1;
        this.asistencia = asistencia;
    }

    /*
     Método con el que se dará inicio al análisis de asistencia
     */
    public void iniciar() {

        /*
         Primero se analiza el turno de forma normal, sin complicaciones       
         luego se sobreponen los permisos
         */
        Date diaInicio = this.getAsistencia().getFecha();

        calendar.setTime(diaInicio);
        calendar.add(Calendar.DATE, 1);

        Date diaSiguiente = calendar.getTime();

        /*
         Buscamos las marcaciones referentes a la asistencia
         */
        cargarMarcacionesDia(this.getAsistencia().getDetalleAsistenciaList(), diaInicio, diaSiguiente);

        this.getAsistencia().getDetalleAsistenciaList().stream().forEach((detalle) -> {
            System.out.println(String.format("-- DETALLE TOLERANCIA -- REFERENCIA: %s TOLERANCIA: %s BANDERA: %s", detalle.getHoraReferencia(), detalle.getHoraReferenciaTolerancia(), detalle.isBandera()));
            Marcacion marcacion
                    = this.buscarMarcacion(
                            detalle.isDiaSiguiente() ? diaSiguiente : diaInicio, detalle.getHoraReferenciaDesde(),
                            detalle.isDiaSiguiente() ? diaSiguiente : diaInicio, detalle.getHoraReferenciaHasta()
                    );
            if (marcacion != null) {
                removerMarcacionFuera(marcacion, 5);
                detalle.setHoraEvento(marcacion.getFechaHora());
                this.removerMarcacionesDuplicadas(marcacion.getFechaHora());
            }
        });

        /*
         Se compara con los permisos y se sobrepone en la asistencia, debe tenerse en cuenta que los permisos pueden ser 
         en varias fechas, o en una sola fecha
         */
        if (this.getPermisos() != null) {
            DetalleAsistencia permisoI = null;
            DetalleAsistencia permisoF = null;
            for (DetalleAsistencia permiso : this.getAsistencia().getPermisoList()) {
                if (permiso.isBandera()) {
                    permisoI = permiso;
                } else {
                    permisoF = permiso;
                    System.out.println("PERMISO I: " + permisoI.getHoraReferencia());
                    System.out.println("PERMISO F: " + permisoF.getHoraReferencia());
                    /*
                     Se buscan los detalles que coinciden con los permisos
                     */
                    for (DetalleAsistencia detalle : this.getAsistencia().getDetalleAsistenciaList()) {

                        if (permisoI.getHoraReferencia().compareTo(detalle.getHoraReferencia()) <= 0
                                && permisoF.getHoraReferencia().compareTo(detalle.getHoraReferencia()) >= 0) {
                            if (detalle.getHoraEvento() == null) {
                                detalle.setPermiso(true);
                            }
                        }
                    }
                }
            }
        }
        
        this.asistencia.setMarcacionesFuera(marcacionesFuera);
    }

    private DetalleAsistencia detalleActual() {
        DetalleAsistencia detalle = this.asistencia.getDetalleAsistenciaList().get(this.posicion);
        return detalle;
    }

    private Marcacion buscarMarcacion(Date fechaInicio, Date horaInicio, Date fechaFin, Date horaFin) {
        Date fechaHoraInicio = FechaUtil.unirFechaHora(fechaInicio, horaInicio);
        Date fechaHoraFin = FechaUtil.unirFechaHora(fechaFin, horaFin);
        System.out.println("FECHA HORA INICIO: " + fechaHoraInicio);
        System.out.println("FECHA HORA FIN: " + fechaHoraFin);
        try {
            return this.marcaciones
                    .stream()
                    .filter(m -> fechaHoraInicio.compareTo(m.getFechaHora()) <= 0 && fechaHoraFin.compareTo(m.getFechaHora()) >= 0)
                    .sorted((m1, m2) -> m1.getFechaHora().compareTo(m2.getFechaHora()))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    
    private List<Marcacion> buscarMarcaciones(Date fechaHoraInicio, Date fechaHoraFin) {
        System.out.println("FECHA HORA INICIO: " + fechaHoraInicio);
        System.out.println("FECHA HORA FIN: " + fechaHoraFin);
        try {
            return this.marcaciones
                    .stream()
                    .filter(m -> fechaHoraInicio.compareTo(m.getFechaHora()) <= 0 && fechaHoraFin.compareTo(m.getFechaHora()) >= 0)
                    .sorted((m1, m2) -> m1.getFechaHora().compareTo(m2.getFechaHora()))
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /*
     método para eliminar las marcaciones en un rango de tiempo de X minutos
     */
    public void removerMarcacionesDuplicadas(Date fechaHora) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaHora);
        cal.add(Calendar.MINUTE, 3);
        this.marcaciones.removeIf(m -> fechaHora.compareTo(m.getFechaHora()) <= 0 && cal.getTime().compareTo(m.getFechaHora()) >= 0);
    }

    private DetalleAsistencia buscarDetalleAsistencia(Date horaReferencia) {
        try {
            return this.getAsistencia().getDetalleAsistenciaList()
                    .stream()
                    .filter(detalle -> detalle.getHoraReferencia().equals(horaReferencia))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    private void cargarMarcacionesDia(List<DetalleAsistencia> detalleAsistenciaList, Date diaInicio, Date diaSiguiente) {
        DetalleAsistencia primerDetalle = detalleAsistenciaList.get(0);
        Date primeraHora = detalleAsistenciaList.get(0).getHoraReferencia();
        int ultimoElemento = detalleAsistenciaList.size() - 1;
        DetalleAsistencia ultimoDetalle = detalleAsistenciaList.get(ultimoElemento);
        Date ultimaHora = detalleAsistenciaList.get(ultimoElemento).getHoraReferencia();

        //Combinamos fecha y hora para evitar problemas con horarios que pasan de fecha
        Date primeraFechaHora = FechaUtil.unirFechaHora(diaInicio, primeraHora);
        Date ultimaFechaHora = FechaUtil.unirFechaHora(ultimoDetalle.isDiaSiguiente() ? diaSiguiente : diaInicio, ultimaHora);

        /*
        Ahora restamos y sumamos un tiempo prudencial para obtener los eventos
        que puedan escapar al control de asistencia regular
         */
        Calendar cal = Calendar.getInstance();
        
        cal.setTime(primeraFechaHora);
        cal.add(Calendar.HOUR, -LIMITE_HORA);
        
        Date primerLimite = cal.getTime();
        
        cal.setTime(ultimaFechaHora);
        cal.add(Calendar.HOUR, LIMITE_HORA);
        
        Date ultimoLimite = cal.getTime();
        System.out.println("LIMITE SUPERIOR: "+primerLimite.toString());
        System.out.println("LIMITE INFERIOR: "+ultimoLimite.toString());
        /*
        Con los limites asignamos las marcaciones a la lista creada
        */
        marcacionesFuera = this.buscarMarcaciones(primerLimite, ultimoLimite);
    }

    private void removerMarcacionFuera(Marcacion marcacion, int limite) {
        /*
        Deben eliminarse marcaciones en un espacio de 5 minutos
        */
        Calendar cal = Calendar.getInstance();
        cal.setTime(marcacion.getFechaHora());
        cal.add(Calendar.MINUTE, limite);
        
        marcacionesFuera.removeIf(m -> m.getFechaHora().compareTo(marcacion.getFechaHora()) >= 0 && m.getFechaHora().compareTo(cal.getTime()) <= 0);
    }
}
