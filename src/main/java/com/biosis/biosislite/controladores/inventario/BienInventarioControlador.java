/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores.inventario;

import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.inventario.Bien;
import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.biosis.biosislite.entidades.inventario.Clase;
import com.biosis.biosislite.entidades.inventario.Inventario;
import com.biosis.biosislite.entidades.inventario.InventarioAmbiente;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Documentos
 */
public class BienInventarioControlador extends AbstractControlador<Bien_Inventario> {

    public BienInventarioControlador() {
        super(Bien_Inventario.class);
    }

    public List<Bien_Inventario> buscarXSerie(String buscar, Inventario inventario) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE (a.codigoFabrica = :buscar OR (CONCAT(a.bien.codigo, a.serie) = :buscar)) AND a.inventario = :inventario";
//                + "AND a.periodo.vigente = false ORDER BY a.periodo.fechaCreacion DESC";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("buscar", buscar);
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }

    public int buscarXBien(Bien bien, Departamento periodo) {
        String jpql = "SELECT COUNT(a) FROM Bien_Inventario a WHERE a.bien = :bien AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("periodo", periodo);
        return this.getDao().contarFiltro(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXBien2(Bien bien) {
        Clase clase = bien.getClase();
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.bien.clase = :clase";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clase", clase);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXBien3(Bien bien, Inventario inventario) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.bien = :bien AND a.inventario = :inventario";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXFecha(Date inicio, Date fin) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Bien_Inventario> buscarXSerieUltima(String serie) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.bien.codigo = :serie";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("serie", serie);
        return this.getDao().buscar(jpql, parametros);
    }

    public String obtenerUltimaSerie(String serie) {
        String jpql = "SELECT MAX(i.serie) FROM Bien_Inventario i WHERE i.bien.codigo = :serie";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("serie", serie);
        return this.getDao().buscarUltimo(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXPeriodo(Periodo periodo) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.periodo = :periodo ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Bien_Inventario> buscarXInventarioAmbiente(InventarioAmbiente inventarioAmbiente) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.inventarioAmbiente = :inventarioAmbiente";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventarioAmbiente", inventarioAmbiente);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXAmbiente(Departamento ambiente) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.ambiente= :ambiente ORDER By a.bien.clase.codigo,a.serie,a.bien.nombre";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ambiente", ambiente);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Bien_Inventario> buscarXArea(Departamento area) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.ambiente.area = :area ORDER By a.bien.clase.codigo,a.serie,a.bien.nombre";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("area", area);
        return this.getDao().buscar(jpql, parametros);
    }

//    public Inventario buscarInventarioXSerie(String buscar) {
//        String jpql = "SELECT a FROM Inventario a WHERE CONCAT(a.bien.clase.codigo, a.serie) = :buscar ";
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("buscar", buscar);
//        List<Inventario> inventarios = new ArrayList();
//        inventarios.clear();
//        inventarios.addAll(this.getDao().buscar(jpql, parametros));
//        System.out.println("TAMAÑO: "+inventarios.size());
//        Inventario elInventario = inventarios.get(0);
//        return elInventario;
//    }
    public List<Bien_Inventario> buscarLazyXFechas(Date inicio, Date fin, int desde, int tamanio) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros, desde, tamanio);
    }

    public int totalXFechas(Date inicio, Date fin) {
        String jpql = "SELECT COUNT(a) FROM Bien_Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Long cont = (Long) this.getDao().getEntityManager().createQuery(jpql).setParameter("inicio", inicio).setParameter("fin", fin).getSingleResult();
        int conteo = cont.intValue();
        return conteo;
    }

    public List<Bien_Inventario> buscarXAmbiente(Departamento ambiente, Periodo periodo) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.ambiente = :ambiente AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ambiente", ambiente);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Bien_Inventario> buscarInventarioXNombreBien(String nombre, Departamento ambiente, Periodo periodo) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.bien.nombre LIKE CONCAT('%',:nombre,'%') AND a.ambiente = :ambiente AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        parametros.put("ambiente", ambiente);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Bien_Inventario> buscarXInventario(Inventario inventario) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.inventario = :inventario";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public int contarStock(Bien bien, Inventario inventario) {
        String jpql = "SELECT COUNT(a) FROM Bien_Inventario a WHERE a.bien = :bien AND a.inventario = :inventario "
                + " AND a.entregado = 0 AND a.baja = 0";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("inventario", inventario);
        return this.getDao().contarFiltro(jpql, parametros);
    }
    
    public List<Bien_Inventario> buscarXImpresion(Inventario inventario) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.inventario = :inventario AND a.impresionPendiente = 1";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Bien_Inventario> buscarXImpresion(Inventario inventario, InventarioAmbiente ambiente) {
        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.inventario = :inventario "
                + " AND a.inventarioAmbiente = :ambiente AND a.impresionPendiente = 1";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inventario", inventario);
        parametros.put("ambiente", ambiente);
        return this.getDao().buscar(jpql, parametros);
    }
    
//    public List<Bien_Inventario> buscarXInventario(Inventario inventario) {
//        String jpql = "SELECT a FROM Bien_Inventario a WHERE a.periodo = :periodo ";
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("inventario", inventario);
//        return this.getDao().buscar(jpql, parametros);
//    }
}
