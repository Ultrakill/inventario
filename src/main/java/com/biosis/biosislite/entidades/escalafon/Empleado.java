package com.biosis.biosislite.entidades.escalafon;

import com.biosis.biosislite.entidades.Alerta;
import com.biosis.biosislite.entidades.DetalleGrupoHorario;
import com.biosis.biosislite.entidades.Incidencia;
import com.biosis.biosislite.entidades.Notificacion;
import com.biosis.biosislite.entidades.educativo.AsignacionNGS;
import com.biosis.biosislite.entidades.educativo.Matricula;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persona", schema = "personal")
public class Empleado implements Serializable {

    @Column(name = "nro_documento", nullable = false)
    @Id
    private String nroDocumento;
    @Column(name="codigo_molecular")
    @Basic
    private String codigoMolecular;
    @Column(name = "nombres", nullable = false)
    @Basic
    private String nombre;
    @Column(name = "condicion")
    @Basic(fetch = FetchType.LAZY)    
    private char condicion = 'A';
//    @OneToOne(fetch = FetchType.LAZY, targetEntity = FichaGeneral.class, mappedBy = "empleado")
//    private FichaGeneral fcihaGeneral;
    @Column(name = "materno", nullable = false)
    @Basic
    private String materno;
    @ManyToOne(targetEntity = TipoDocumento.class)
    @JoinColumn(name = "tipo_documento_codigo", referencedColumnName = "codigo")
    private TipoDocumento tipoDocumento;
    @Column(name = "sexo", nullable = false)
    @Basic(fetch = FetchType.LAZY)    
    private char sexo;
    @Column(name = "paterno", nullable = false)
    @Basic
    private String paterno;
    @Column(name= "tipo_persona", nullable = false)
    @Basic
    private Integer tipoPersona;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = FichaLaboral.class, mappedBy = "empleado",cascade = CascadeType.ALL)
    private FichaLaboral fichaLaboral;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = FichaGeneral.class, mappedBy = "empleado",cascade = CascadeType.ALL)
    private FichaGeneral fichaGeneral;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Contrato.class,mappedBy = "empleado",cascade = CascadeType.ALL)
    private List<Contrato> contratoList;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @Basic(fetch = FetchType.LAZY)    
    private Date fechaNacimiento;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleGrupoHorario.class,mappedBy = "empleado")
    private List<DetalleGrupoHorario> detalleGrupoHorarioList;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = AreaEmpleado.class,mappedBy = "empleado")
    private List<AreaEmpleado> areaEmpleadoList;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Matricula.class,mappedBy = "alumno")
    private List<Matricula> matriculaList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Matricula.class,mappedBy = "apoderado")
    private List<Matricula> matriculaListA;
    
    /**
     * Lista de incidencias del empleado
     */
    @OneToMany(targetEntity = Incidencia.class,mappedBy = "empleado",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Incidencia> incidenciaList;
    
    /**
     * Lista de alertas de un empleado
     */
    @OneToMany(targetEntity = Alerta.class,mappedBy = "empleado",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Alerta> alertaList;
    
    /**
     * Lista de notificaciones para empleado que es emisor
     */
    @OneToMany(targetEntity = Notificacion.class,mappedBy = "emisor",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Notificacion> notificacionListEmisor;
    
    /**
     * Lista de notificaciones para empleado que es emisor
     */
    @OneToMany(targetEntity = Notificacion.class,mappedBy = "receptor",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Notificacion> notificacionListReceptor;
    
    
    @OneToMany(targetEntity = AsignacionNGS.class,mappedBy = "responsable",orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AsignacionNGS> asignacionNGSList;
    
    public List<AreaEmpleado> getAreaEmpleadoList() {
        return areaEmpleadoList;
    }

    public void setAreaEmpleadoList(List<AreaEmpleado> areaEmpleadoList) {
        this.areaEmpleadoList = areaEmpleadoList;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }        

    public List<DetalleGrupoHorario> getDetalleGrupoHorarioList() {
        return detalleGrupoHorarioList;
    }

    public void setDetalleGrupoHorarioList(List<DetalleGrupoHorario> detalleGrupoHorarioList) {
        this.detalleGrupoHorarioList = detalleGrupoHorarioList;
    }    
    
    public String getNombreCompleto(){
        return String.format("%s %s %s", this.paterno, this.materno, this.nombre);
    }

    public Empleado() {

    }

    public FichaGeneral getFichaGeneral() {
        return fichaGeneral;
    }

    public void setFichaGeneral(FichaGeneral fichaGeneral) {
        this.fichaGeneral = fichaGeneral;
    }

    public String getNroDocumento() {
        return this.nroDocumento;
    }

    public String getCodigoMolecular() {
        return codigoMolecular;
    }

    public void setCodigoMolecular(String codigoMolecular) {
        this.codigoMolecular = codigoMolecular;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getCondicion() {
        return this.condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    public String getMaterno() {
        return this.materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getPaterno() {
        return this.paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public Integer getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Integer tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    
    public FichaLaboral getFichaLaboral() {
        return this.fichaLaboral;
    }

    public void setFichaLaboral(FichaLaboral fichaLaboral) {
        this.fichaLaboral = fichaLaboral;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<Matricula> getMatriculaListA() {
        return matriculaListA;
    }

    public void setMatriculaListA(List<Matricula> matriculaListA) {
        this.matriculaListA = matriculaListA;
    }

    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    public List<Alerta> getAlertaList() {
        return alertaList;
    }

    public void setAlertaList(List<Alerta> alertaList) {
        this.alertaList = alertaList;
    }

    public List<Notificacion> getNotificacionListEmisor() {
        return notificacionListEmisor;
    }

    public void setNotificacionListEmisor(List<Notificacion> notificacionListEmisor) {
        this.notificacionListEmisor = notificacionListEmisor;
    }

    public List<Notificacion> getNotificacionListReceptor() {
        return notificacionListReceptor;
    }

    public void setNotificacionListReceptor(List<Notificacion> notificacionListReceptor) {
        this.notificacionListReceptor = notificacionListReceptor;
    }

    public List<AsignacionNGS> getAsignacionNGSList() {
        return asignacionNGSList;
    }

    public void setAsignacionNGSList(List<AsignacionNGS> asignacionNGSList) {
        this.asignacionNGSList = asignacionNGSList;
    }

    /**
     * @return Integer
     * Retorna el correlativo del documento
     */
    public Integer getCodigoTipoDocumento(){
        String[] items = this.codigoMolecular.split(",");
        return Integer.parseInt(items[0]);
    }
    
    @Override
    public String toString() {
        return nombre +" " +paterno+" " + materno+" ("+nroDocumento + ")";
    }
    
    
}
