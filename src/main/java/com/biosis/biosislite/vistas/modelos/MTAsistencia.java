/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.algoritmo.AnalizadorAsistencia;
import com.biosis.biosislite.algoritmo.AnalizadorDiario;
import com.personal.utiles.FechaUtil;
import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.controladores.MarcacionControlador;
import com.biosis.biosislite.entidades.Marcacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.reportes.RptAsistenciaDetallado;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import com.biosis.biosislite.utiles.HerramientaGeneral;

/**
 *
 * @author Francis
 */
public class MTAsistencia extends ModeloTabla<RptAsistenciaDetallado> {

    private final DecimalFormat formatoDecimal;

    public MTAsistencia(List<RptAsistenciaDetallado> datos) {
        super(datos);
        this.formatoDecimal = new DecimalFormat("#.00");
        this.nombreColumnas 
                = new String[]{
                    "Código SAP", 
                    "Empleado", 
                    "Fecha", 
                    "Horario", 
                    "Asistencia", 
                    "Entrada", 
                    "Salida", 
                    "Entrada", 
                    "Salida", 
                    "Descripción", 
                    "Tardanza (min)", 
                    "Tardanza Refrigerio (min)", 
                    "Extra (min)",
                    "M.N.P."
                };
    }
//
//    private Empleado empleado;
//    private Date fecha;

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        RptAsistenciaDetallado asistencia = this.datos.get(rowIndex);
//        int marcacionesPendientes = this.numeroMarcacionesPendientes(asistencia);
////        System.out.println("MARCACIONES TOTALES: "+asistencia.getMarcacionesTotales());
//        empleado = asistencia.getEmpleado();
//        fecha = asistencia.getFecha();
        if (asistencia.getTipo() == AnalizadorAsistencia.REGULAR
                || asistencia.getTipo() == AnalizadorAsistencia.TARDANZA
                || asistencia.getTipo() == AnalizadorAsistencia.INASISTENCIA
                || asistencia.getTipo() == AnalizadorAsistencia.INCONSISTENCIA) {
            switch (columnIndex) {
                case 0:
                    return asistencia.getEmpleado().getFichaLaboral().getCodigoTrabajador();
                case 1:
                    return asistencia.getEmpleado().getNombreCompleto();
                case 2:
                    return HerramientaGeneral.formatoNombreDiaFecha.format(asistencia.getFecha()).toUpperCase();
                case 3:
                    return asistencia.getReferencias().trim();
                case 4:
                    return this.obtenerTipo(asistencia.getTipo());
                case 5:
                    return this.obtenerEvento(asistencia.isEnPermiso1(), asistencia.getHoraEvento1());
                case 6:
                    return this.obtenerEvento(asistencia.isEnPermiso2(), asistencia.getHoraEvento2());
                case 7:
                    if (asistencia.getMarcacionesTotales() > 2) {
                        return this.obtenerEvento(asistencia.isEnPermiso3(), asistencia.getHoraEvento3());
                    } else {
                        return null;
                    }                    
                case 8:
                    if (asistencia.getMarcacionesTotales() > 2) {
                        return this.obtenerEvento(asistencia.isEnPermiso4(), asistencia.getHoraEvento4());
                    } else {
                        return null;
                    }
                case 9:
                    return asistencia.getPermisos().trim();
                case 10:
                    return String.format("%.2f", asistencia.getMinutosTardanza());
                case 11:
                    return String.format("%.2f", asistencia.getMinutosTardanzaRefrigerio());

                case 12:
                    return String.format("%.2f", asistencia.getMinutosExtra());
                case 13:
                    return asistencia.getMarcacionesFuera();
                default:
                    return null;
            }
        } else {

            switch (columnIndex) {
                case 0:
                    return asistencia.getEmpleado().getFichaLaboral().getCodigoTrabajador();
                case 1:
                    return asistencia.getEmpleado().getNombreCompleto();
                case 2:
                    return HerramientaGeneral.formatoNombreDiaFecha.format(asistencia.getFecha()).toUpperCase();
                case 4:
                    return this.obtenerTipo(asistencia.getTipo());
                case 9:
                    return asistencia.getPermisos();
                default:
                    return null;
            }
        }

    }

    private double tardanza(Date horaTolerancia, Date horaMarcada) {
        Long diferencia = horaMarcada == null ? 0 : horaMarcada.after(horaTolerancia) ? horaMarcada.getTime() - horaTolerancia.getTime() : 0;
        double diferenciaMin = diferencia.intValue() / (60 * 1000);
        return diferenciaMin;
//        return this.formatoDecimal.format(diferenciaMin);
    }

//    private Integer numeroMarcacionesPendientes(RptAsistencia asistencia) {
//        int conteo = 0;
//
//        if (asistencia.getDetalle1().getHoraEntrada() == null) {
//            conteo++;
//        }
//
//        if (asistencia.getDetalle1().getHoraSalida() == null) {
//            conteo++;
//        }
//
//        if (asistencia.getDetalle2().getHoraEntrada() == null) {
//            conteo++;
//        }
//
//        if (asistencia.getDetalle2().getHoraSalida() == null) {
//            conteo++;
//        }
//
//        return conteo;
//    }
    private String extra(Date horaSalida, Date horaMarcada) {
        Long diferencia = horaMarcada == null ? 0 : horaMarcada.after(horaSalida) ? horaMarcada.getTime() - horaSalida.getTime() : 0;
        double diferenciaMin = diferencia.intValue() / (60 * 1000);
        return this.formatoDecimal.format(diferenciaMin);
    }


    public Marcacion buscarMarcacionFalta(Date fechaInicio, Date horaInicio, Date fechaFin, Date horaFin) {
        Date fechaHoraInicio = FechaUtil.unirFechaHora(fechaInicio, horaInicio);
        Date fechaHoraFin = FechaUtil.unirFechaHora(fechaFin, horaFin);
        System.out.println("FECHA HORA INICIO: " + fechaHoraInicio);
        System.out.println("FECHA HORA FIN FALTA: " + fechaHoraFin);
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

    private List<Marcacion> marcaciones;

    private Object obtenerEvento(boolean enPermiso, Date horaEvento) {
        if (enPermiso) {
            return "PERMISO";
        } else {
            if (horaEvento == null) {
                return "SIN MARCACIÓN";
            } else {
                return HerramientaGeneral.formatoHoraMinutoSegundo.format(horaEvento);
            }
        }
    }

    private Object obtenerTipo(int tipo) {
        switch (tipo) {
            case AnalizadorAsistencia.REGULAR:
                return "REGULAR";
            case AnalizadorAsistencia.TARDANZA:
                return "TARDANZA";
            case AnalizadorAsistencia.INASISTENCIA:
                return "INASISTENCIA";
            case AnalizadorAsistencia.PERMISO_FECHA:
            case AnalizadorAsistencia.BOLETA_PERMISO:
                return "PERMISO";
            case AnalizadorAsistencia.FERIADO:
                return "FERIADO";
            case AnalizadorAsistencia.VACACION:
            case AnalizadorAsistencia.BOLETA_VACACION:
                return "VACACION";
            case AnalizadorAsistencia.INCONSISTENCIA:
                return "INCONSISTENCIA";
            default:
                return "";
        }
    }

}
