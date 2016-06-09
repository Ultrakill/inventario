/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos;

import com.biosis.biosislite.controladores.AreaEmpleadoControlador;
import com.biosis.biosislite.controladores.ContratoControlador;
import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.DepartamentoControlador;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.controladores.GerenciaControlador;
import com.biosis.biosislite.controladores.NivelEducativoControlador;
import com.biosis.biosislite.controladores.PuestoEmpleadoControlador;
import com.biosis.biosislite.controladores.RegimenLaboralControlador;
import com.biosis.biosislite.controladores.SituacionTrabajadorControlador;
import com.biosis.biosislite.controladores.TipoContratoControlador;
import com.biosis.biosislite.controladores.TipoDocumentoControlador;
import com.biosis.biosislite.controladores.TipoViaControlador;
import com.biosis.biosislite.controladores.TipoZonaControlador;
import com.biosis.biosislite.entidades.escalafon.AreaEmpleado;
import com.biosis.biosislite.entidades.escalafon.Contrato;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.escalafon.FichaGeneral;
import com.biosis.biosislite.entidades.escalafon.FichaLaboral;
import com.biosis.biosislite.entidades.escalafon.Gerencia;
import com.biosis.biosislite.entidades.escalafon.Nacionalidad;
import com.biosis.biosislite.entidades.escalafon.NivelEducativo;
import com.biosis.biosislite.entidades.escalafon.PuestoEmpleado;
import com.biosis.biosislite.entidades.escalafon.RegimenLaboral;
import com.biosis.biosislite.entidades.escalafon.SituacionTrabajador;
import com.biosis.biosislite.entidades.escalafon.TipoContrato;
import com.biosis.biosislite.entidades.escalafon.TipoDocumento;
import com.biosis.biosislite.entidades.escalafon.TipoVia;
import com.biosis.biosislite.entidades.escalafon.TipoZona;
import com.biosis.biosislite.entidades.escalafon.Ubigeo;
import com.personal.utiles.FechaUtil;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author fesquivelc
 */
public class DlgEmpleadoCRUD extends javax.swing.JDialog {

    /**
     * Creates new form VistaEmpleado
     */
    private List<AreaEmpleado> lista = new ArrayList();
    private List<Contrato> lista2 = new ArrayList();
    private List<PuestoEmpleado> lista3 = new ArrayList();
    
    
    private boolean tab = true;

    private final EmpleadoControlador ec;
    private final JInternalFrame padre;
    private boolean agregar;

    //CONTROLADORES
    private final TipoDocumentoControlador tdc = TipoDocumentoControlador.getInstance();
    private final DepartamentoControlador dc = DepartamentoControlador.getInstance();
    private final NivelEducativoControlador nec = NivelEducativoControlador.getInstance();
    private final TipoViaControlador tvc = TipoViaControlador.getInstance();
    private final TipoZonaControlador tzc = TipoZonaControlador.getInstance();
    private final GerenciaControlador gc = new GerenciaControlador();
    private final TipoContratoControlador tcc = TipoContratoControlador.getInstance();
    private final RegimenLaboralControlador rlc = RegimenLaboralControlador.getInstance();
    private final SituacionTrabajadorControlador stc = SituacionTrabajadorControlador.getInstance();

    private final AreaEmpleadoControlador ea = new AreaEmpleadoControlador();
    private final ContratoControlador cc = ContratoControlador.getInstance();
    private final PuestoEmpleadoControlador pec = PuestoEmpleadoControlador.getInstance();

    private final Empleado empleado;
    private final int accion;

    private int accionT = 0;

    public boolean isAgregar() {
        return agregar;
    }

    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    public DlgEmpleadoCRUD(JInternalFrame parent, Empleado empleado, int accion) {
        super(JOptionPane.getFrameForComponent(parent), true);
        this.empleado = empleado;
        this.accion = accion;
        padre = parent;
        initComponents();
        iniciar();
        ec = new EmpleadoControlador();
        agregar = true;
        ec.setSeleccionado(empleado);
        if (this.accion == Controlador.MODIFICAR) {
            this.mostrarDatos(empleado);
        }
        if (this.accion == Controlador.NUEVO) {
            tab = false;
            this.tblPane.setEnabledAt(2, false);
        }

        this.setLocationRelativeTo(parent);
        listarArea();
        listarContratos();        
        listarCargos();

        FormularioUtil.activarComponente(panelDatosC, false);
        FormularioUtil.activarComponente(panelDatosA, false);
        FormularioUtil.activarComponente(panelDatosP, false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tblPane = new javax.swing.JTabbedPane();
        pnlEmpleado = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlNavegacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        cboTipoDocumento = new javax.swing.JComboBox();
        cboGenero = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtNroDocumento = new javax.swing.JTextField();
        pnlGenerales = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboEstadoCivil = new javax.swing.JComboBox();
        cboNivelEducativo = new javax.swing.JComboBox();
        txtEmail = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        btnNacionalidad = new javax.swing.JButton();
        txtTelefono1 = new javax.swing.JTextField();
        txtTelefono2 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnUbigeo = new javax.swing.JButton();
        txtUbigeo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboTipoVia = new javax.swing.JComboBox();
        cboTipoZona = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        tabDatosLaborales = new javax.swing.JTabbedPane();
        pnlDatosContrato = new javax.swing.JPanel();
        panelTblC = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContratos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panelDatosC = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtCodigoTrabajador = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cboTipoContrato = new javax.swing.JComboBox();
        cboRegimenLaboral = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel31 = new javax.swing.JLabel();
        dcFechaFin = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jPanel1 = new javax.swing.JPanel();
        btnAgregarC = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnModDatosC = new javax.swing.JButton();
        pnlDatosArea = new javax.swing.JPanel();
        panelTblA = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAreas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        panelDatosA = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        dtFechaInicio = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel30 = new javax.swing.JLabel();
        dtFechaFin = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jPanel7 = new javax.swing.JPanel();
        btnAgregarA = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btnModAreasA = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        cboGerencia = new javax.swing.JComboBox();
        pnlDatosCargo = new javax.swing.JPanel();
        panelTblP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        panelDatosP = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        dtFechaInicioCargo = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel32 = new javax.swing.JLabel();
        dtFechaFinCargo = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jPanel9 = new javax.swing.JPanel();
        btnCancelarP = new javax.swing.JButton();
        btnModPuestos = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();

        setTitle("DATOS DE EMPLEADO");
        setResizable(false);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0};
        jPanel1Layout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        pnlEmpleado.setLayout(jPanel1Layout);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        pnlEmpleado.add(jPanel2, gridBagConstraints);

        pnlNavegacion.setLayout(new java.awt.GridLayout(1, 0, 2, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        pnlEmpleado.add(pnlNavegacion, gridBagConstraints);

        jLabel1.setText("Tipo documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel1, gridBagConstraints);

        txtPaterno.setColumns(40);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(txtPaterno, gridBagConstraints);

        jLabel3.setText("Apellido paterno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Apellido materno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Género:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel5, gridBagConstraints);

        txtMaterno.setColumns(40);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(txtMaterno, gridBagConstraints);

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(cboTipoDocumento, gridBagConstraints);

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(cboGenero, gridBagConstraints);

        jLabel7.setText("Fecha de nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel8, gridBagConstraints);

        txtNombres.setColumns(40);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(txtNombres, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(dcFechaNacimiento, gridBagConstraints);

        jLabel23.setText("Número de documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(jLabel23, gridBagConstraints);

        txtNroDocumento.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlEmpleado.add(txtNroDocumento, gridBagConstraints);

        tblPane.addTab("Datos personales", pnlEmpleado);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Estado civil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel10, gridBagConstraints);

        jLabel12.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel12, gridBagConstraints);

        jLabel11.setText("Nivel educativo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel11, gridBagConstraints);

        jLabel13.setText("Nacionalidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel13, gridBagConstraints);

        jLabel2.setText("Teléfono 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel6.setText("Teléfono 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel6, gridBagConstraints);

        jLabel9.setText("Dirección:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel14.setText("Ubigeo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel14, gridBagConstraints);

        cboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CASADO (A)", "SOLTERO (A)", "VIUDO (A)", "DIVORCIADO (A)" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(cboEstadoCivil, gridBagConstraints);

        cboNivelEducativo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(cboNivelEducativo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtEmail, gridBagConstraints);

        txtNacionalidad.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtNacionalidad, gridBagConstraints);

        btnNacionalidad.setText("...");
        btnNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNacionalidadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnNacionalidad, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtTelefono1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtTelefono2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtDireccion, gridBagConstraints);

        btnUbigeo.setText("...");
        btnUbigeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbigeoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnUbigeo, gridBagConstraints);

        txtUbigeo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtUbigeo, gridBagConstraints);

        jLabel15.setText("Tipo vía:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel15, gridBagConstraints);

        jLabel16.setText("Tipo zona:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel16, gridBagConstraints);

        cboTipoVia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(cboTipoVia, gridBagConstraints);

        cboTipoZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(cboTipoZona, gridBagConstraints);

        pnlGenerales.setViewportView(jPanel4);

        tblPane.addTab("Datos generales", pnlGenerales);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        pnlDatosContrato.setLayout(new java.awt.GridBagLayout());

        panelTblC.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial de Contratos"));
        panelTblC.setMaximumSize(new java.awt.Dimension(380, 2147483647));
        panelTblC.setMinimumSize(new java.awt.Dimension(380, 69));
        panelTblC.setPreferredSize(new java.awt.Dimension(380, 448));
        panelTblC.setLayout(new java.awt.GridBagLayout());

        tblContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblContratos.setMaximumSize(new java.awt.Dimension(380, 64));
        tblContratos.setMinimumSize(new java.awt.Dimension(350, 64));
        tblContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblContratosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblContratos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        panelTblC.add(jScrollPane1, gridBagConstraints);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jButton6.setText("Nuevo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);

        jButton7.setText("Editar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelTblC.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        pnlDatosContrato.add(panelTblC, gridBagConstraints);

        panelDatosC.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        java.awt.GridBagLayout panelDatosCLayout = new java.awt.GridBagLayout();
        panelDatosCLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        panelDatosCLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        panelDatosC.setLayout(panelDatosCLayout);

        jLabel24.setText("Código de planilla:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatosC.add(jLabel24, gridBagConstraints);

        txtCodigoTrabajador.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosC.add(txtCodigoTrabajador, gridBagConstraints);

        jLabel25.setText("Tipo de contrato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatosC.add(jLabel25, gridBagConstraints);

        cboTipoContrato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoContrato.setMaximumSize(new java.awt.Dimension(180, 32767));
        cboTipoContrato.setMinimumSize(new java.awt.Dimension(180, 20));
        cboTipoContrato.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosC.add(cboTipoContrato, gridBagConstraints);

        cboRegimenLaboral.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRegimenLaboral.setMaximumSize(new java.awt.Dimension(180, 32767));
        cboRegimenLaboral.setMinimumSize(new java.awt.Dimension(180, 20));
        cboRegimenLaboral.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosC.add(cboRegimenLaboral, gridBagConstraints);

        jLabel28.setText("Régimen laboral:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatosC.add(jLabel28, gridBagConstraints);

        jLabel27.setText("Fecha de inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatosC.add(jLabel27, gridBagConstraints);

        dcFechaInicio.setDateFormatString("dd/MM/yyyy");
        dcFechaInicio.setMaximumSize(new java.awt.Dimension(120, 24));
        dcFechaInicio.setMinSelectableDate(new java.util.Date(21703000L));
        dcFechaInicio.setMinimumSize(new java.awt.Dimension(120, 24));
        dcFechaInicio.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosC.add(dcFechaInicio, gridBagConstraints);

        jLabel31.setText("Fecha de fin:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatosC.add(jLabel31, gridBagConstraints);

        dcFechaFin.setDateFormatString("dd/MM/yyyy");
        dcFechaFin.setMaximumSize(new java.awt.Dimension(120, 24));
        dcFechaFin.setMinSelectableDate(new java.util.Date(21703000L));
        dcFechaFin.setMinimumSize(new java.awt.Dimension(120, 24));
        dcFechaFin.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosC.add(dcFechaFin, gridBagConstraints);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnAgregarC.setText("Agregar");
        btnAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarC);

        jButton9.setText("Cancelar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);

        btnModDatosC.setText("Modificar");
        btnModDatosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModDatosCActionPerformed(evt);
            }
        });
        jPanel1.add(btnModDatosC);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        panelDatosC.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlDatosContrato.add(panelDatosC, gridBagConstraints);

        tabDatosLaborales.addTab("Datos de contratos", pnlDatosContrato);

        pnlDatosArea.setLayout(new java.awt.GridBagLayout());

        panelTblA.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial de Áreas"));
        panelTblA.setMaximumSize(new java.awt.Dimension(380, 2147483647));
        panelTblA.setMinimumSize(new java.awt.Dimension(380, 69));
        panelTblA.setLayout(new java.awt.GridBagLayout());

        tblAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAreasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblAreas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        panelTblA.add(jScrollPane2, gridBagConstraints);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jButton10.setText("Nuevo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton10);

        jButton11.setText("Editar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton11);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panelTblA.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        pnlDatosArea.add(panelTblA, gridBagConstraints);

        panelDatosA.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        panelDatosA.setLayout(new java.awt.GridBagLayout());

        jLabel21.setText("Area: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosA.add(txtArea, gridBagConstraints);

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jButton5, gridBagConstraints);

        jLabel22.setText("Fecha Inicio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jLabel22, gridBagConstraints);

        dtFechaInicio.setDateFormatString("dd/MM/yyyy");
        dtFechaInicio.setMaximumSize(new java.awt.Dimension(120, 24));
        dtFechaInicio.setMinSelectableDate(new java.util.Date(21703000L));
        dtFechaInicio.setMinimumSize(new java.awt.Dimension(120, 24));
        dtFechaInicio.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosA.add(dtFechaInicio, gridBagConstraints);

        jLabel30.setText("Fecha Fin: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jLabel30, gridBagConstraints);

        dtFechaFin.setDateFormatString("dd/MM/yyyy");
        dtFechaFin.setMaximumSize(new java.awt.Dimension(120, 24));
        dtFechaFin.setMinSelectableDate(new java.util.Date(21703000L));
        dtFechaFin.setMinimumSize(new java.awt.Dimension(120, 24));
        dtFechaFin.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        panelDatosA.add(dtFechaFin, gridBagConstraints);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        btnAgregarA.setText("Agregar");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregarA);

        jButton13.setText("Cancelar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13);

        btnModAreasA.setText("Modificar");
        btnModAreasA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModAreasAActionPerformed(evt);
            }
        });
        jPanel7.add(btnModAreasA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.1;
        panelDatosA.add(jPanel7, gridBagConstraints);

        jLabel33.setText("Gerencia: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jLabel33, gridBagConstraints);

        jLabel34.setText("Unidad Negocio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosA.add(jLabel34, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDatosA.add(txtUnidad, gridBagConstraints);

        jButton17.setText("...");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        panelDatosA.add(jButton17, gridBagConstraints);

        cboGerencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGerencia.setMaximumSize(new java.awt.Dimension(200, 32767));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDatosA.add(cboGerencia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlDatosArea.add(panelDatosA, gridBagConstraints);

        tabDatosLaborales.addTab("Datos de áreas", pnlDatosArea);

        panelTblP.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial de Cargos"));
        panelTblP.setMaximumSize(new java.awt.Dimension(380, 2147483647));
        panelTblP.setMinimumSize(new java.awt.Dimension(380, 69));
        panelTblP.setLayout(new java.awt.GridBagLayout());

        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCargosMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblCargos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        panelTblP.add(jScrollPane3, gridBagConstraints);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jButton12.setText("Nuevo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12);

        jButton14.setText("Editar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton14);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panelTblP.add(jPanel10, gridBagConstraints);

        panelDatosP.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        panelDatosP.setLayout(new java.awt.GridBagLayout());

        jLabel26.setText("Cargo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        panelDatosP.add(jLabel26, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDatosP.add(txtCargo, gridBagConstraints);

        jButton8.setText("...");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        panelDatosP.add(jButton8, gridBagConstraints);

        jLabel29.setText("Fecha Inicio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosP.add(jLabel29, gridBagConstraints);

        dtFechaInicioCargo.setDateFormatString("dd/MM/yyyy");
        dtFechaInicioCargo.setMaximumSize(new java.awt.Dimension(120, 24));
        dtFechaInicioCargo.setMinSelectableDate(new java.util.Date(21703000L));
        dtFechaInicioCargo.setMinimumSize(new java.awt.Dimension(120, 24));
        dtFechaInicioCargo.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDatosP.add(dtFechaInicioCargo, gridBagConstraints);

        jLabel32.setText("Fecha Fin: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatosP.add(jLabel32, gridBagConstraints);

        dtFechaFinCargo.setDateFormatString("dd/MM/yyyy");
        dtFechaFinCargo.setMaximumSize(new java.awt.Dimension(120, 24));
        dtFechaFinCargo.setMinSelectableDate(new java.util.Date(21703000L));
        dtFechaFinCargo.setMinimumSize(new java.awt.Dimension(120, 24));
        dtFechaFinCargo.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDatosP.add(dtFechaFinCargo, gridBagConstraints);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.1;
        panelDatosP.add(jPanel9, gridBagConstraints);

        btnCancelarP.setText("Cancelar");
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        panelDatosP.add(btnCancelarP, gridBagConstraints);

        btnModPuestos.setText("Modificar");
        btnModPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModPuestosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        panelDatosP.add(btnModPuestos, gridBagConstraints);

        btnAgregarP.setText("Agregar");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        panelDatosP.add(btnAgregarP, gridBagConstraints);

        javax.swing.GroupLayout pnlDatosCargoLayout = new javax.swing.GroupLayout(pnlDatosCargo);
        pnlDatosCargo.setLayout(pnlDatosCargoLayout);
        pnlDatosCargoLayout.setHorizontalGroup(
            pnlDatosCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosCargoLayout.createSequentialGroup()
                .addComponent(panelTblP, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatosP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDatosCargoLayout.setVerticalGroup(
            pnlDatosCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosCargoLayout.createSequentialGroup()
                .addGroup(pnlDatosCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTblP, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(panelDatosP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tabDatosLaborales.addTab("Datos de cargos", pnlDatosCargo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(tabDatosLaborales, gridBagConstraints);

        tblPane.addTab("Datos laborales", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tblPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblPane, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNacionalidadActionPerformed
        // TODO add your handling code here:
        DlgNacionalidad dlgNac = new DlgNacionalidad(this);
        nacionalidadSeleccion = dlgNac.getSeleccionado();
        mostrarNacionalidad(nacionalidadSeleccion);
    }//GEN-LAST:event_btnNacionalidadActionPerformed

    private void btnUbigeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbigeoActionPerformed
        // TODO add your handling code here:
        DlgUbigeo dlgUbi = new DlgUbigeo(this);
        ubigeoSeleccion = dlgUbi.getSeleccionado();
        mostrarUbigeo(ubigeoSeleccion);
    }//GEN-LAST:event_btnUbigeoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!hayErrores()) {
            guardar();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    Contrato contratosG;
    PuestoEmpleado puestoE;
    List<Contrato> listaContratosG = new ArrayList();

    private void Agregar() {
        contratosG.setEmpleado(empleado);
        contratosG.setFechaInicio(dcFechaInicio.getDate());
        contratosG.setFechaFin(dcFechaFin.getDate());
        contratosG.setTipoContrato((TipoContrato) cboTipoContrato.getSelectedItem());
        contratosG.setRegimenLaboral((RegimenLaboral) cboRegimenLaboral.getSelectedItem());

        listaContratosG.add(contratosG);
        lista2.add(contratosG);

        FormularioUtil.activarComponente(this.panelDatosC, false);
        FormularioUtil.activarComponente(panelTblC, true);
    }
    private void btnAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Contrato")) {
            Agregar();
        }
    }//GEN-LAST:event_btnAgregarCActionPerformed
    AreaEmpleado areaF;
    List<AreaEmpleado> listaAreaEmpleadoG = new ArrayList();

    private void AgregarArea() {
        areaF.setEmpleado(empleado);
        areaF.setFechaInicio(dtFechaInicio.getDate());
        areaF.setFechaFin(dtFechaFin.getDate());
        areaF.setGerencia((Gerencia)cboGerencia.getSelectedItem());

        listaAreaEmpleadoG.add(areaF);
        lista.add(areaF);

        FormularioUtil.activarComponente(this.panelDatosA, false);
        FormularioUtil.activarComponente(panelTblA, true);
    }
    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Area")) {
            AgregarArea();
        }

    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DlgAreaBusqueda areaBusqueda = new DlgAreaBusqueda(this);

//        areaBusqueda.setVisible(true);
        areaF.setDepartamento(areaBusqueda.getArea());
        if (areaF.getDepartamento() != null) {
            this.txtArea.setText(this.areaF.getDepartamento().getNombre().toUpperCase());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        contratosG = new Contrato();
        FormularioUtil.activarComponente(this.panelDatosC, true);
        FormularioUtil.activarComponente(this.panelTblC, false);
        btnModDatosC.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        areaF = new AreaEmpleado();
        FormularioUtil.activarComponente(this.panelDatosA, true);
        FormularioUtil.activarComponente(this.panelTblA, false);
        btnModAreasA.setEnabled(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        accionT = Controlador.MODIFICAR;

        int fila = this.tblContratos.getSelectedRow();
        if (fila != -1) {
            FormularioUtil.activarComponente(panelDatosC, true);
            btnAgregarC.setEnabled(false);
            FormularioUtil.activarComponente(panelTblC, false);

            cc.setSeleccionado(lista2.get(fila));
            Contrato cont = cc.getSeleccionado();
            cboRegimenLaboral.setSelectedItem(cont.getRegimenLaboral());
            cboTipoContrato.setSelectedItem(cont.getTipoContrato());
            dcFechaInicio.setDate(cont.getFechaInicio());
            dcFechaFin.setDate(cont.getFechaFin());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento de la tabla", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    Contrato contratoMOD;
    private void tblContratosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContratosMouseReleased
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {

            int fila = tblContratos.getSelectedRow();
            this.contratoMOD = lista2.get(fila);

            cboRegimenLaboral.setSelectedItem(contratoMOD.getRegimenLaboral());
            cboTipoContrato.setSelectedItem(contratoMOD.getTipoContrato());
            dcFechaInicio.setDate(contratoMOD.getFechaInicio());
            dcFechaFin.setDate(contratoMOD.getFechaFin());

        }
    }//GEN-LAST:event_tblContratosMouseReleased

    private void Modificar() {
        Contrato contratoCambio = cc.getSeleccionado();

        contratoCambio.setEmpleado(empleado);
        contratoCambio.setFechaInicio(dcFechaInicio.getDate());
        contratoCambio.setFechaFin(dcFechaFin.getDate());
        contratoCambio.setTipoContrato((TipoContrato) cboTipoContrato.getSelectedItem());
        contratoCambio.setRegimenLaboral((RegimenLaboral) cboRegimenLaboral.getSelectedItem());

        cc.setSeleccionado(contratoCambio);

        cc.accion(accionT);
        FormularioUtil.activarComponente(this.panelDatosC, false);
        FormularioUtil.activarComponente(panelTblC, true);
    }
    private void btnModDatosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModDatosCActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Contrato")) {
            Modificar();
        }

    }//GEN-LAST:event_btnModDatosCActionPerformed

    private void ModificarArea() {
        AreaEmpleado empleadoAreaCambio = ea.getSeleccionado();

        empleadoAreaCambio.setEmpleado(empleado);
        empleadoAreaCambio.setFechaInicio(dtFechaInicio.getDate());
        empleadoAreaCambio.setFechaFin(dtFechaFin.getDate());

        ea.setSeleccionado(empleadoAreaCambio);

        ea.accion(accionT);
        FormularioUtil.activarComponente(this.panelDatosA, false);
        FormularioUtil.activarComponente(panelTblA, true);
    }
    private void btnModAreasAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModAreasAActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Area")) {
            ModificarArea();
        }
    }//GEN-LAST:event_btnModAreasAActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        FormularioUtil.limpiarComponente(panelDatosA);
        FormularioUtil.activarComponente(panelDatosA, false);
        FormularioUtil.activarComponente(panelTblA, true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        listaAreaEmpleadoG.clear();
        listaContratosG.clear();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        FormularioUtil.limpiarComponente(panelDatosC);
        FormularioUtil.activarComponente(panelDatosC, false);
        FormularioUtil.activarComponente(panelTblC, true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        accionT = Controlador.MODIFICAR;

        int fila = this.tblAreas.getSelectedRow();
        if (fila != -1) {
            FormularioUtil.activarComponente(panelDatosA, true);
            btnAgregarA.setEnabled(false);
            FormularioUtil.activarComponente(panelTblA, false);

            ea.setSeleccionado(lista.get(fila));
            AreaEmpleado areaEmpleados = ea.getSeleccionado();

            txtArea.setText(areaEmpleados.getDepartamento().getNombre());
            dcFechaInicio.setDate(areaEmpleados.getFechaInicio());
            dcFechaFin.setDate(areaEmpleados.getFechaFin());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento de la tabla", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    AreaEmpleado areaEmpMOD;
    private void tblAreasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreasMouseReleased
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {

            int fila = tblAreas.getSelectedRow();
            this.areaEmpMOD = lista.get(fila);

            txtArea.setText(areaEmpMOD.getDepartamento().getNombre());
            dtFechaInicio.setDate(areaEmpMOD.getFechaInicio());
            dtFechaFin.setDate(areaEmpMOD.getFechaFin());

        }
    }//GEN-LAST:event_tblAreasMouseReleased

    private void tblCargosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCargosMouseReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        puestoE = new PuestoEmpleado();
        FormularioUtil.activarComponente(this.panelDatosP, true);
        FormularioUtil.activarComponente(this.panelTblP, false);
        btnModPuestos.setEnabled(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        accionT = Controlador.MODIFICAR;

        int fila = this.tblCargos.getSelectedRow();
        if (fila != -1) {
            FormularioUtil.activarComponente(panelDatosP, true);
            btnAgregarP.setEnabled(false);
            FormularioUtil.activarComponente(panelTblP, false);

            pec.setSeleccionado(lista3.get(fila));
            PuestoEmpleado puestoEmpleados = pec.getSeleccionado();

            txtCargo.setText(puestoEmpleados.getPuesto().getNombre());
            dcFechaInicio.setDate(puestoEmpleados.getFechaInicio());
            dcFechaFin.setDate(puestoEmpleados.getFechaFin());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento de la tabla", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        DlgCargos cargoBusqueda = new DlgCargos(this);        
        
        cargoBusqueda.setVisible(true);
        
//        System.out.println("VALIDACION DE CARGO: "+cargoBusqueda.getCargo().getNombre());
        
        puestoE.setPuesto(cargoBusqueda.getCargo());
        if (puestoE.getPuesto()!= null) {
            this.txtCargo.setText(this.puestoE.getPuesto().getNombre().toUpperCase());
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Cargo")) {
            AgregarCargo();
        }
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        // TODO add your handling code here:
        FormularioUtil.limpiarComponente(panelDatosP);
        FormularioUtil.activarComponente(panelDatosP, false);
        FormularioUtil.activarComponente(panelTblP, true);
    }//GEN-LAST:event_btnCancelarPActionPerformed

    private void btnModPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModPuestosActionPerformed
        // TODO add your handling code here:
        if (!hayErroresLaborales("Cargo")) {
            ModificarCargo();
        }
        
    }//GEN-LAST:event_btnModPuestosActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        DlgUnidadNegocio unidadBusqueda = new DlgUnidadNegocio(this);
        unidadBusqueda.setVisible(true);
        
        areaF.setUnidad(unidadBusqueda.getUnidadNegocio());
        if (areaF.getUnidad() != null) {
            this.txtUnidad.setText(this.areaF.getUnidad().getNombre().toUpperCase());
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private Ubigeo ubigeoSeleccion;
    private Nacionalidad nacionalidadSeleccion;
    private Empleado empleadoSeleccionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarC;
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnCancelarP;
    private javax.swing.JButton btnModAreasA;
    private javax.swing.JButton btnModDatosC;
    private javax.swing.JButton btnModPuestos;
    private javax.swing.JButton btnNacionalidad;
    private javax.swing.JButton btnUbigeo;
    private javax.swing.JComboBox cboEstadoCivil;
    private javax.swing.JComboBox cboGenero;
    private javax.swing.JComboBox cboGerencia;
    private javax.swing.JComboBox cboNivelEducativo;
    private javax.swing.JComboBox cboRegimenLaboral;
    private javax.swing.JComboBox cboTipoContrato;
    private javax.swing.JComboBox cboTipoDocumento;
    private javax.swing.JComboBox cboTipoVia;
    private javax.swing.JComboBox cboTipoZona;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaFinCargo;
    private com.toedter.calendar.JDateChooser dtFechaInicio;
    private com.toedter.calendar.JDateChooser dtFechaInicioCargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelDatosA;
    private javax.swing.JPanel panelDatosC;
    private javax.swing.JPanel panelDatosP;
    private javax.swing.JPanel panelTblA;
    private javax.swing.JPanel panelTblC;
    private javax.swing.JPanel panelTblP;
    private javax.swing.JPanel pnlDatosArea;
    private javax.swing.JPanel pnlDatosCargo;
    private javax.swing.JPanel pnlDatosContrato;
    private javax.swing.JPanel pnlEmpleado;
    private javax.swing.JScrollPane pnlGenerales;
    private javax.swing.JPanel pnlNavegacion;
    private javax.swing.JTabbedPane tabDatosLaborales;
    private javax.swing.JTable tblAreas;
    private javax.swing.JTable tblCargos;
    private javax.swing.JTable tblContratos;
    private javax.swing.JTabbedPane tblPane;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodigoTrabajador;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtUbigeo;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

//    private void buscar() {
//        lista.clear();
//        lista.addAll(ec.buscarXPatron(txtBusqueda.getText()));
//        tblEmpleado.packAll();
//    }
    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public Empleado getSeleccionado() {
        this.setVisible(true);
        return getEmpleadoSeleccionado();
    }

    private void iniciar() {
        FormularioUtil.activarComponente(this.dcFechaInicio, true);
        FormularioUtil.activarComponente(this.dcFechaNacimiento, true);
        FormularioUtil.activarComponente(this.dcFechaInicio, true);

        cboTipoDocumento.setModel(new DefaultComboBoxModel(tdc.buscarTodos().toArray()));
        cboTipoDocumento.setRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof TipoDocumento) {
                    value = ((TipoDocumento) value).getNombre();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        });

//        cboOficina.setModel(new DefaultComboBoxModel(dc.buscarTodos().toArray()));
//        cboOficina.setRenderer(new DefaultListCellRenderer() {
//
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                if (value instanceof Departamento) {
//                    value = ((Departamento) value).getNombre();
//                }
//                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
//            }
//
//        });
        cboNivelEducativo.setModel(new DefaultComboBoxModel(nec.buscarTodos().toArray()));
        cboNivelEducativo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                value = value instanceof NivelEducativo ? ((NivelEducativo) value).getDescripcion() : value;
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });

        cboTipoVia.setModel(new DefaultComboBoxModel(tvc.buscarTodos().toArray()));
        cboTipoVia.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                value = value instanceof TipoVia ? ((TipoVia) value).getAbreviatura() : value;
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });

        cboTipoZona.setModel(new DefaultComboBoxModel(tzc.buscarTodos().toArray()));
        cboTipoZona.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                value = value instanceof TipoZona ? ((TipoZona) value).getAbreviatura() : value;
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });

        cboTipoContrato.setModel(new DefaultComboBoxModel(tcc.buscarTodos().toArray()));
        cboTipoContrato.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                value = value instanceof TipoContrato ? ((TipoContrato) value).getDescripcion() : value;
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });

        cboRegimenLaboral.setModel(new DefaultComboBoxModel(rlc.buscarTodos().toArray()));
        cboRegimenLaboral.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                value = value instanceof RegimenLaboral ? ((RegimenLaboral) value).getNombre() : value;
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });

//        cboSituacionEmpleado.setModel(new DefaultComboBoxModel(stc.buscarTodos().toArray()));
//        cboSituacionEmpleado.setRenderer(new DefaultListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                value = value instanceof SituacionTrabajador ? ((SituacionTrabajador) value).getDescripcion() : value;
//                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
        cboGerencia.setModel(new DefaultComboBoxModel(gc.buscarTodos().toArray()));
        
        if (this.accion == Controlador.MODIFICAR) {
            mostrarDatos(this.empleado);
        }
    }

    private void mostrarNacionalidad(Nacionalidad nacionalidadSeleccion) {
        this.txtNacionalidad.setText(nacionalidadSeleccion == null ? "" : String.format("%s - %s", nacionalidadSeleccion.getCodigo(), nacionalidadSeleccion.getDescripcion()));
    }

    private void mostrarUbigeo(Ubigeo seleccionado) {
        this.txtUbigeo.setText(seleccionado == null ? "" : String.format("%s / %s / %s", seleccionado.getDepartamento(), seleccionado.getProvincia(), seleccionado.getDistrito()));
    }

    private void guardar() {
        if (FormularioUtil.dialogoConfirmar(this, accion)) {
            if (this.accion == Controlador.NUEVO) {
                empleado.setNroDocumento(txtNroDocumento.getText());

            }

//            FormularioUtil.convertirMayusculas(pnlLaborales);
            FormularioUtil.convertirMayusculas(pnlEmpleado);
            FormularioUtil.convertirMayusculas(pnlGenerales);

            empleado.setCondicion('A');
            empleado.setFechaNacimiento(dcFechaNacimiento.getDate());
            empleado.setMaterno(txtMaterno.getText());
            empleado.setPaterno(txtPaterno.getText());
            empleado.setNombre(txtNombres.getText());
            empleado.setSexo(cboGenero.getSelectedItem().toString().charAt(0));
            empleado.setTipoDocumento((TipoDocumento) cboTipoDocumento.getSelectedItem());

            FichaGeneral fgen = empleado.getFichaGeneral();
            if (fgen == null) {
                FichaGeneral fichaGeneralCreada = new FichaGeneral();
                empleado.setFichaGeneral(fichaGeneralCreada);
                fichaGeneralCreada.setEmpleado(empleado);
                fgen = empleado.getFichaGeneral();
            }

            fgen.setDireccion(txtDireccion.getText());
            fgen.setEmail(txtEmail.getText().toLowerCase());
            fgen.setEstadoCivil(cboEstadoCivil.getSelectedItem().toString().charAt(0));
            fgen.setNacionalidad(nacionalidadSeleccion);
            fgen.setNivelEducativo((NivelEducativo) cboNivelEducativo.getSelectedItem());
            fgen.setTelefono1(txtTelefono1.getText());
            fgen.setTelefono2(txtTelefono2.getText());
            fgen.setTipoVia((TipoVia) cboTipoVia.getSelectedItem());
            fgen.setTipoZona((TipoZona) cboTipoZona.getSelectedItem());
            fgen.setUbigeoResidencia(ubigeoSeleccion);

            FichaLaboral flab = empleado.getFichaLaboral();
//            flab.setArea((Departamento) this.cboOficina.getSelectedItem());
            flab.setCodigoTrabajador(txtNroDocumento.getText());
//            flab.setFechaInicio(dcFechaInicio.getDate());
//            flab.setRegimenLaboral((RegimenLaboral) cboRegimenLaboral.getSelectedItem());
//            flab.setSituacionTrabajador((SituacionTrabajador) cboSituacionEmpleado.getSelectedItem());
//            flab.setTipoContrato((TipoContrato) cboTipoContrato.getSelectedItem());

            if (tab = true) {
                if (!listaAreaEmpleadoG.isEmpty()) {
                    System.out.println("EL TAMAÑO DE AREAS ES: " + listaAreaEmpleadoG.size());
                    for (AreaEmpleado listas : listaAreaEmpleadoG) {
                        ea.setSeleccionado(listas);

                        ea.accion(accion);
                    }
                }

                if (!listaContratosG.isEmpty()) {
                    System.out.println("EL TAMAÑO DE CONTRATOS ES: " + listaContratosG.size());
                    for (Contrato listas2 : listaContratosG) {
                        cc.setSeleccionado(listas2);
                        cc.accion(accion);
                    }
                }
                
                if (!listaPuestoEmpleadoG.isEmpty()) {
                    System.out.println("EL TAMAÑO DE CARGOS ES: " + listaPuestoEmpleadoG.size());
                    for (PuestoEmpleado listas : listaPuestoEmpleadoG) {
                        pec.setSeleccionado(listas);

                        pec.accion(accion);
                    }
                }
            }

            if (ec.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);

                this.dispose();

            } else {
                FormularioUtil.mensajeError(this, accion);
            }
        }

    }

    private void mostrarDatos(Empleado empleado) {
        //DATOS PERSONALES
        cboTipoDocumento.setSelectedItem(empleado.getTipoDocumento());
        txtNroDocumento.setText(empleado.getNroDocumento());
        txtNombres.setText(empleado.getNombre());
        txtPaterno.setText(empleado.getPaterno());
        txtMaterno.setText(empleado.getMaterno());
        cboGenero.setSelectedIndex(empleado.getSexo() == 'M' ? 0 : 1);
        dcFechaNacimiento.setDate(empleado.getFechaNacimiento());

        //DATOS GENERALES
        FichaGeneral general = empleado.getFichaGeneral();

        if (general != null) {

            char sexo = general.getEstadoCivil();
            System.out.println("ESTADO C: " + sexo);

            switch (sexo) {
                case 'C':
                    cboEstadoCivil.setSelectedIndex(0);
                    break;
                case 'S':
                    cboEstadoCivil.setSelectedIndex(1);
                    break;
                case 'V':
                    cboEstadoCivil.setSelectedIndex(2);
                    break;
                case 'D':
                    cboEstadoCivil.setSelectedIndex(3);
                    break;
            }

            cboNivelEducativo.setSelectedItem(
                    general.getNivelEducativo() == null
                    ? cboNivelEducativo.getSelectedItem()
                    : general.getNivelEducativo()
            );

            txtEmail.setText(general.getEmail() == null ? "" : general.getEmail());

            this.nacionalidadSeleccion = general.getNacionalidad();
            mostrarNacionalidad(nacionalidadSeleccion);

            this.ubigeoSeleccion = general.getUbigeoResidencia();
            mostrarUbigeo(ubigeoSeleccion);
            txtTelefono1.setText(general.getTelefono1());
            txtTelefono2.setText(general.getTelefono2());
            cboTipoVia.setSelectedItem(general.getTipoVia());
            cboTipoZona.setSelectedItem(general.getTipoZona());
            txtDireccion.setText(general.getDireccion());
        }
        //DATOS FICHA LABORAL
        FichaLaboral laboral = empleado.getFichaLaboral();
//        cboOficina.setSelectedItem(laboral.getArea());
        txtCodigoTrabajador.setText(laboral.getCodigoTrabajador() == null ? "" : laboral.getCodigoTrabajador());
//        cboTipoContrato.setSelectedItem(laboral.getTipoContrato());
//        cboRegimenLaboral.setSelectedItem(laboral.getRegimenLaboral());
//        dcFechaInicio.setDate(laboral.getFechaInicio());
//        cboSituacionEmpleado.setSelectedItem(laboral.getSituacionTrabajador());

    }

    private void listarArea() {
        System.out.println("TAMAÑO: " + lista.size());
        System.out.println("EMPLEADO: " + empleado);
        if (accion != Controlador.NUEVO) {
            lista = this.ea.buscarXNombrexFechaASC(empleado);
        }
        lista = ObservableCollections.observableList(lista);

        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblAreas);

        BeanProperty bEmpleado = BeanProperty.create("empleado");
        BeanProperty bFechaInicio = BeanProperty.create("fechaInicio");
        BeanProperty bFechaFin = BeanProperty.create("fechaFin");
        BeanProperty bArea = BeanProperty.create("departamento");
        BeanProperty bGerencia = BeanProperty.create("gerencia");
        BeanProperty bUnidad = BeanProperty.create("unidad");

        binding.addColumnBinding(bEmpleado).setColumnName("EMPLEADO").setEditable(false);
        binding.addColumnBinding(bFechaInicio).setColumnName("FECHA INICIO").setEditable(false);
        binding.addColumnBinding(bFechaFin).setColumnName("FECHA FIN").setEditable(false);
        binding.addColumnBinding(bArea).setColumnName("AREA").setEditable(false);
        binding.addColumnBinding(bGerencia).setColumnName("GERENCIA").setEditable(false);
        binding.addColumnBinding(bUnidad).setColumnName("UNIDAD").setEditable(false);
        

        binding.bind();
    }

    private void listarContratos() {
        if (accion != Controlador.NUEVO) {
            lista2 = this.cc.buscarXNombrexFechaASC(empleado);
        }
        lista2 = ObservableCollections.observableList(lista2);
        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista2, tblContratos);

        BeanProperty bEmpleado = BeanProperty.create("empleado");
        BeanProperty bFechaInicio = BeanProperty.create("fechaInicio");
        BeanProperty bFechaFin = BeanProperty.create("fechaFin");
        BeanProperty bTipoContrato = BeanProperty.create("tipoContrato");
        BeanProperty bRegimenLaboral = BeanProperty.create("regimenLaboral");

        binding.addColumnBinding(bEmpleado).setColumnName("EMPLEADO").setEditable(false);
        binding.addColumnBinding(bFechaInicio).setColumnName("FECHA INICIO").setEditable(false);
        binding.addColumnBinding(bFechaFin).setColumnName("FECHA FIN").setEditable(false);
        binding.addColumnBinding(bTipoContrato).setColumnName("TIPO").setEditable(false);
        binding.addColumnBinding(bRegimenLaboral).setColumnName("REGIMEN").setEditable(false);

        binding.bind();
    }

    private boolean hayErrores() {
        //COMPROBAMOS LOS DISTINTOS TIPOS
        String mensajeError = "Se han detectado los siguientes errores:\n";
        int errores = 0;

        if (!(StringUtils.isNumeric(this.txtTelefono1.getText()) && StringUtils.isNumeric(this.txtTelefono2.getText()))) {
            mensajeError += "- El campo teléfono debe ser numérico\n";
            errores++;
        }

        if (errores > 0) {
            JOptionPane.showMessageDialog(this, mensajeError, "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
        }
        return errores != 0;
    }

    private boolean hayErroresLaborales(String tipo) {
        //COMPROBAMOS LOS DISTINTOS TIPOS

        String mensajeError = "Se han detectado los siguientes errores:\n";
        int errores = 0;

//        if(!(StringUtils.isNumeric(this.txtTelefono1.getText()) && StringUtils.isNumeric(this.txtTelefono2.getText()))){
//            mensajeError += "- El campo teléfono debe ser numérico\n";
//            errores++;
//        }
        List<Contrato> listaContratos = cc.buscarXNombrexFechaASC(empleado);
        List<AreaEmpleado> listaAreas = ea.buscarXNombrexFechaASC(empleado);
        List<PuestoEmpleado> listaCargos = pec.buscarXNombrexFechaASC(empleado);

        int conteo = 0;
        int erroresContratos = 0;
        int erroresCargos = 0;

        if (tipo.equals("Contrato")) {
            for (Contrato contratosList : listaContratos) {

                if (contratosList.getFechaFin() == null) {
                    if (dcFechaInicio.getDate().compareTo(contratosList.getFechaInicio()) != 0) {
                        conteo++;
                    }
                } else if (((dcFechaInicio.getDate().compareTo(contratosList.getFechaInicio()) <= 0) & (dcFechaFin.getDate().compareTo(contratosList.getFechaInicio()) >= 0)) || ((dcFechaInicio.getDate().compareTo(contratosList.getFechaInicio()) >= 0) & (dcFechaInicio.getDate().compareTo(contratosList.getFechaFin()) <= 0))) {
                    erroresContratos++;
                }
            }
        }
        if (tipo.equals("Area")) {
            for (AreaEmpleado areaList : listaAreas) {

                if (areaList.getFechaFin() == null) {
                    if (dtFechaInicio.getDate().compareTo(areaList.getFechaInicio()) != 0) {
                        conteo++;
                    }
                } else if (((dtFechaInicio.getDate().compareTo(areaList.getFechaInicio()) <= 0) & (dtFechaFin.getDate().compareTo(areaList.getFechaInicio()) >= 0)) || ((dtFechaInicio.getDate().compareTo(areaList.getFechaInicio()) >= 0) & (dtFechaInicio.getDate().compareTo(areaList.getFechaFin()) <= 0))) {
                    erroresContratos++;
                }
            }
        }
        
        if (tipo.equals("Cargo")) {
            for (PuestoEmpleado cargoList : listaCargos) {

                if (cargoList.getFechaFin() == null) {
                    if (dtFechaInicioCargo.getDate().compareTo(cargoList.getFechaInicio()) != 0) {
                        conteo++;
                    }
                } else if (((dtFechaInicioCargo.getDate().compareTo(cargoList.getFechaInicio()) <= 0) & (dtFechaFinCargo.getDate().compareTo(cargoList.getFechaInicio()) >= 0)) || ((dtFechaInicioCargo.getDate().compareTo(cargoList.getFechaInicio()) >= 0) & (dtFechaInicioCargo.getDate().compareTo(cargoList.getFechaFin()) <= 0))) {
                    erroresCargos++;
                }
            }
        }
        if (conteo > 0) {
            mensajeError += "- Se debe finalizar el ciclo del " + tipo + " antes de agregar otro\n";
            errores++;
        }

        if (erroresContratos > 0) {
            mensajeError += "- Rango de fechas se encuentra en conflicto con algún " + tipo + "\n";
            errores++;
        }
        
        if (erroresCargos > 0) {
            mensajeError += "- Rango de fechas se encuentra en conflicto con algún " + tipo + "\n";
            errores++;
        }

//        boolean x = dcFechaFin.getDate().after(dcFechaInicio.getDate());
        if (tipo.equals("Contrato")) {
            if (dcFechaFin.getDate() != null) {
                if (FechaUtil.soloFecha(dcFechaFin.getDate()).compareTo(FechaUtil.soloFecha(dcFechaInicio.getDate())) <= 0) {
                    mensajeError += "- La fecha de fin debe ser mayor a la fecha de inicio\n";
                    errores++;
                }
            }
        } else if (tipo.equals("Area")) {
            if (dtFechaFin.getDate() != null) {
                if (FechaUtil.soloFecha(dtFechaFin.getDate()).compareTo(FechaUtil.soloFecha(dtFechaInicio.getDate())) <= 0) {
                    mensajeError += "- La fecha de fin debe ser mayor a la fecha de inicio\n";
                    errores++;
                }
            }

        }else if (tipo.equals("Cargo")) {
            if (dtFechaFinCargo.getDate() != null) {
                if (FechaUtil.soloFecha(dtFechaFinCargo.getDate()).compareTo(FechaUtil.soloFecha(dtFechaInicioCargo.getDate())) <= 0) {
                    mensajeError += "- La fecha de fin debe ser mayor a la fecha de inicio\n";
                    errores++;
                }
            }

        }

        if (errores > 0) {
            JOptionPane.showMessageDialog(this, mensajeError, "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
        }
        return errores != 0;
    }

    List<PuestoEmpleado> puestos = new ArrayList();
//    PuestoEmpleadoControlador pec = PuestoEmpleadoControlador.getInstance();
    
    private void listarCargos() {
        if (accion != Controlador.NUEVO) {
            lista3 = this.pec.buscarXNombrexFechaASC(empleado);
        }
        lista3 = ObservableCollections.observableList(lista3);
        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista3, tblCargos);

        BeanProperty bEmpleado = BeanProperty.create("empleado");
        BeanProperty bFechaInicio = BeanProperty.create("fechaInicio");
        BeanProperty bFechaFin = BeanProperty.create("fechaFin");
        BeanProperty bCargo = BeanProperty.create("puesto");

        binding.addColumnBinding(bEmpleado).setColumnName("EMPLEADO").setEditable(false);
        binding.addColumnBinding(bFechaInicio).setColumnName("FECHA INICIO").setEditable(false);
        binding.addColumnBinding(bFechaFin).setColumnName("FECHA FIN").setEditable(false);
        binding.addColumnBinding(bCargo).setColumnName("CARGO").setEditable(false);

        binding.bind();
    }

//    PuestoEmpleado puestoE;
    List<PuestoEmpleado> listaPuestoEmpleadoG = new ArrayList();
    private void AgregarCargo() {
        puestoE.setEmpleado(empleado);
        puestoE.setFechaInicio(dtFechaInicioCargo.getDate());
        puestoE.setFechaFin(dtFechaFinCargo.getDate());

        listaPuestoEmpleadoG.add(puestoE);
        lista3.add(puestoE);

        FormularioUtil.activarComponente(this.panelDatosP, false);
        FormularioUtil.activarComponente(panelTblP, true);
    }

    private void ModificarCargo() {
        PuestoEmpleado empleadoPuesto = pec.getSeleccionado();

        empleadoPuesto.setEmpleado(empleado);
        empleadoPuesto.setFechaInicio(dtFechaInicioCargo.getDate());
        empleadoPuesto.setFechaFin(dtFechaFinCargo.getDate());

        pec.setSeleccionado(empleadoPuesto);

        pec.accion(accionT);
        FormularioUtil.activarComponente(this.panelDatosP, false);
        FormularioUtil.activarComponente(panelTblP, true);
    }
}
