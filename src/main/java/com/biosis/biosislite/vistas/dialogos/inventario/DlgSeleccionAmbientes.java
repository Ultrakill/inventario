/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos.inventario;

import com.biosis.biosislite.entidades.inventario.Bien_Inventario;
import com.biosis.biosislite.entidades.inventario.Inventario;
import com.biosis.biosislite.entidades.inventario.InventarioAmbiente;
import com.biosis.biosislite.controladores.inventario.BienInventarioControlador;
import com.biosis.biosislite.controladores.inventario.InventarioAmbienteControlador;
import com.biosis.biosislite.controladores.inventario.InventarioControlador;
import com.biosis.biosislite.utiles.Exportador;
import com.biosis.biosislite.utiles.ExportadorTXT;
import com.biosis.biosislite.vistas.Principal;
import com.biosis.biosislite.vistas.inventario.ActualizarInventario;
import com.biosis.biosislite.vistas.modelos.MTInventarioAmbiente;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Documentos
 */
public class DlgSeleccionAmbientes extends JDialog {

    /**
     * Creates new form DlgSeleccionAmbientes
     */
//    private List<InventarioAmbiente> listaAmbientes;
    private Inventario inventario;
    private InventarioAmbiente ambienteInventario;
    private BienInventarioControlador bic = new BienInventarioControlador();
    private InventarioControlador inventarioC = new InventarioControlador();

    private InventarioAmbiente ambienteInventarioProceso;

    public DlgSeleccionAmbientes(Component componente, Inventario inventario) {
        super(JOptionPane.getFrameForComponent(componente), true);
        initComponents();
        this.inventario = inventario;
        inventarioC.setSeleccionado(this.inventario);
        bindeoSalvaje();
        bindeoSalvaje2();
        cargarAmbientes(this.inventario);
        this.setLocationRelativeTo(componente);
        FormularioUtil.activarComponente(this.pnlBienAmbiente, false);
        this.txtResponsable.setEditable(false);
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

        pnlAmbientes = new javax.swing.JPanel();
        pnlBienAmbiente = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chckInvCompleto = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        lblAmbiente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbFormatos = new javax.swing.JComboBox();
        btnExportar = new javax.swing.JButton();
        pnlListaAmbientes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        chckAmbienteIncompleto = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAmbientesInventario = new org.jdesktop.swingx.JXTable();

        setTitle("Proceso de Inventarios - Ambientes");

        java.awt.GridBagLayout pnlAmbientesLayout = new java.awt.GridBagLayout();
        pnlAmbientesLayout.columnWidths = new int[] {0, 11, 0};
        pnlAmbientesLayout.rowHeights = new int[] {0};
        pnlAmbientes.setLayout(pnlAmbientesLayout);

        pnlBienAmbiente.setBorder(javax.swing.BorderFactory.createTitledBorder("Bienes Inventariados del Ambiente:"));
        java.awt.GridBagLayout pnlBienAmbienteLayout = new java.awt.GridBagLayout();
        pnlBienAmbienteLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        pnlBienAmbienteLayout.rowHeights = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
        pnlBienAmbiente.setLayout(pnlBienAmbienteLayout);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(txtBuscar, gridBagConstraints);

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblInventarioMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblInventario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlBienAmbiente.add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ambiente: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlBienAmbiente.add(jLabel1, gridBagConstraints);

        jLabel3.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(jLabel3, gridBagConstraints);

        chckInvCompleto.setText("Inventario completo");
        chckInvCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckInvCompletoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(chckInvCompleto, gridBagConstraints);

        jLabel4.setText("Buscar Bien inventariado en este ambiente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(jLabel4, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setText("Iniciar Proceso");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(jPanel4, gridBagConstraints);

        jLabel2.setText("Responsable/encargado: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 303;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBienAmbiente.add(txtResponsable, gridBagConstraints);

        lblAmbiente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlBienAmbiente.add(lblAmbiente, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Elegir formato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(jLabel6, gridBagConstraints);

        cmbFormatos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbFormatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excel (*.xls)", "Texto (*.txt)" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(cmbFormatos, gridBagConstraints);

        btnExportar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarjButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(btnExportar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlBienAmbiente.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        pnlAmbientes.add(pnlBienAmbiente, gridBagConstraints);

        pnlListaAmbientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Ambiente"));
        pnlListaAmbientes.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
        pnlListaAmbientes.setLayout(jPanel2Layout);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlListaAmbientes.add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        pnlListaAmbientes.add(jTextField1, gridBagConstraints);

        jButton2.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlListaAmbientes.add(jButton2, gridBagConstraints);

        chckAmbienteIncompleto.setText("Ver ambientes con inventario incompletos");
        chckAmbienteIncompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckAmbienteIncompletoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlListaAmbientes.add(chckAmbienteIncompleto, gridBagConstraints);

        jLabel5.setText("Importar Bienes del último inventario?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnlListaAmbientes.add(jLabel5, gridBagConstraints);

        jButton6.setText("Importar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlListaAmbientes.add(jButton6, gridBagConstraints);

        tblAmbientesInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAmbientesInventarioMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAmbientesInventario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlListaAmbientes.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnlAmbientes.add(pnlListaAmbientes, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAmbientes, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAmbientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    List<Bien_Inventario> lista;
    BienInventarioControlador inventarioControlador = new BienInventarioControlador();

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:       

        int fila = tblAmbientesInventario.getSelectedRow();

//            System.out.println("CODIGO-AMBIENTE: " + listaAmbientesxInventario.get(fila).getId());
        if (fila != -1) {
            this.ambienteInventarioProceso = listaAmbientesxInventario.get(fila);

            this.lblAmbiente.setText(listaAmbientesxInventario.get(fila).getAmbiente().getNombre());
            this.chckInvCompleto.setSelected(listaAmbientesxInventario.get(fila).getInventario().getImportado());
            if (listaAmbientesxInventario.get(fila).getAmbiente().getEmpleado() != null) {
                this.txtResponsable.setText(listaAmbientesxInventario.get(fila).getAmbiente().getEmpleado().getNombreCompleto());
            }

            List<Bien_Inventario> listaB = bic.buscarXInventarioAmbiente(listaAmbientesxInventario.get(fila));
            listaBienes.clear();
            listaBienes.addAll(listaB);

            FormularioUtil.activarComponente(pnlListaAmbientes, false);
            FormularioUtil.activarComponente(pnlBienAmbiente, true);
            txtResponsable.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento de la lista", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        if (!this.inventario.getImportado()) {
            DlgInventarioSeleccion inventarioDialog = new DlgInventarioSeleccion(this, this.inventario);
            Inventario inventarioImportar = inventarioDialog.getInventario();

            if (inventarioImportar != null) {

                //        List<InventarioAmbiente> ambientesImportar = inventarioImportar.getInventarioAmbienteList();
                List<Bien_Inventario> bienImportar = bic.buscarXInventario(inventarioImportar);
                System.out.println("Lista de Bienes: " + bienImportar.size());

                if (!bienImportar.isEmpty()) {

                    for (Bien_Inventario listas : bienImportar) {
                        Bien_Inventario nuevoBienInv = new Bien_Inventario();
                        bic.setSeleccionado(nuevoBienInv);

                        bic.getSeleccionado().setInventario(this.inventario);
                        bic.getSeleccionado().setInventarioAmbiente(PareoAmbientes(listas.getInventarioAmbiente()));
                        bic.getSeleccionado().setBien(listas.getBien());
                        bic.getSeleccionado().setFechaIngreso(new Date());
                        bic.getSeleccionado().setImpresionPendiente(false);
                        bic.getSeleccionado().setPrecio(listas.getPrecio());
                        bic.getSeleccionado().setProveedor(listas.getProveedor());
                        bic.getSeleccionado().setFactura(listas.getFactura());
                        bic.getSeleccionado().setEstado(listas.getEstado());
                        bic.getSeleccionado().setDescripcion(listas.getDescripcion());
                        bic.getSeleccionado().setCodigoFabrica(listas.getCodigoFabrica());
                        bic.getSeleccionado().setSerie(listas.getSerie());
                        bic.getSeleccionado().setBaja(listas.isBaja());

                        bic.getSeleccionado().setZona(listas.getZona());
                        bic.getSeleccionado().setEstante(listas.getEstante());
                        bic.getSeleccionado().setColumna(listas.getColumna());
                        bic.getSeleccionado().setFila(listas.getFila());
                        bic.getSeleccionado().setAltura(listas.getAltura());

                        bic.accion(1);

                    }

                    inventarioC.getSeleccionado().setImportado(true);
                    inventarioC.accion(2);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya se ha importado en este inventario", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        lista.clear();
        //        lista.addAll(inventarioControlador.buscarInventarioXNombreBien(txtBuscar.getText().toUpperCase(), ambiente, (Periodo) cmbPeriodo.getSelectedItem()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ActualizarInventario inicioP = new ActualizarInventario(this, this.inventario, this.ambienteInventarioProceso);
        inicioP.setVisible(true);

        List<Bien_Inventario> listaB = bic.buscarXInventarioAmbiente(this.ambienteInventarioProceso);
        listaBienes.clear();
        listaBienes.addAll(listaB);
            //            agregarAPanel(inicioP, true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseReleased
        // TODO add your handling code here:
        //        if (evt.getClickCount() == 2) {
        //
        //            accion = AbstractControlador.MODIFICAR;
        //
        //            FormularioUtil.activarComponente(panelGuardar, true);
        //            FormularioUtil.activarComponente(panelDatos, true);
        //
        //            int fila = tblInventario.getSelectedRow();
        //            Bien_Inventario bien = lista.get(fila);
        //            inventarioControlador.setSeleccionado(bien);
        //
        //            ambienteField1.setText(inventarioControlador.getSeleccionado().getInventarioAmbiente().toString());
        //            //            if(inventarioControlador.getSeleccionado().getImpresionPendiente() != null){
        //                //                chckImprimir.setSelected(inventarioControlador.getSeleccionado().getImpresionPendiente());
        //                //            }
        //
        //            lblSerie.setText(inventarioControlador.getSeleccionado().getSerie());
        //            lblBien.setText(inventarioControlador.getSeleccionado().getBien().getNombre());
        //        }
    }//GEN-LAST:event_tblInventarioMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       
        listaBienes.clear();
        chckInvCompleto.setSelected(false);
        FormularioUtil.limpiarComponente(pnlBienAmbiente);
        FormularioUtil.activarComponente(pnlBienAmbiente, false);
        FormularioUtil.activarComponente(pnlListaAmbientes, true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblAmbientesInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAmbientesInventarioMouseReleased
        // TODO add your handling code here:
        //        int fila = tblBien.getSelectedRow();
        //        if (fila != -1) {
        //            Vacacion vacacion = listado.get(fila);
        //
        //            mostrar(vacacion);
        //        }
    }//GEN-LAST:event_tblAmbientesInventarioMouseReleased

    private void chckInvCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckInvCompletoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chckInvCompletoActionPerformed

    private void chckAmbienteIncompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckAmbienteIncompletoActionPerformed
        // TODO add your handling code here:
        listaAmbientesxInventario.clear();
        if(chckAmbienteIncompleto.isSelected()){
            listaAmbientesxInventario.addAll(this.ic.buscarXInventarioIncompleto(inventario));
            tblAmbientesInventario.packAll();
        }else{
            listaAmbientesxInventario.clear();
            tblAmbientesInventario.packAll();
        }
        
    }//GEN-LAST:event_chckAmbienteIncompletoActionPerformed

    private void btnExportarjButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarjButton5ActionPerformed
        // TODO add your handling code here:

        if(cmbFormatos.getSelectedIndex()==0){
            ExportarXLS();
        }else if(cmbFormatos.getSelectedIndex()==1){
            ExportarTXT();
        }
    }//GEN-LAST:event_btnExportarjButton5ActionPerformed

    private InventarioAmbiente PareoAmbientes(InventarioAmbiente ambiente) {
        ambiente.getAmbiente();

        return ic.buscarXAmbientexInventario(ambiente.getAmbiente(), this.inventario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JCheckBox chckAmbienteIncompleto;
    private javax.swing.JCheckBox chckInvCompleto;
    private javax.swing.JComboBox cmbFormatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAmbiente;
    private javax.swing.JPanel pnlAmbientes;
    private javax.swing.JPanel pnlBienAmbiente;
    private javax.swing.JPanel pnlListaAmbientes;
    private org.jdesktop.swingx.JXTable tblAmbientesInventario;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtResponsable;
    // End of variables declaration//GEN-END:variables

    List<InventarioAmbiente> listaAmbientesxInventario;
    List<Bien_Inventario> listaBienes;

    private void bindeoSalvaje() {

        listaAmbientesxInventario = new ArrayList();
        listaAmbientesxInventario = ObservableCollections.observableList(listaAmbientesxInventario);

//        JTableBinding bindeoDetalle = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, listaAmbientesxInventario, tblAmbientesInventario);
//
////        BeanProperty bId = BeanProperty.create("Id");
//        BeanProperty ambiente = BeanProperty.create("ambiente");
//        BeanProperty binventario = BeanProperty.create("inventario");
//        BeanProperty estado = BeanProperty.create("estado");
//
////        bindeoDetalle.addColumnBinding(bId).setColumnName("ID").setEditable(false);
//        bindeoDetalle.addColumnBinding(ambiente).setColumnName("AMBIENTE").setEditable(false);
//        bindeoDetalle.addColumnBinding(binventario).setColumnName("INVENTARIO").setEditable(false);
//        bindeoDetalle.addColumnBinding(estado).setColumnName("ESTADO").setEditable(false);
//
//        bindeoDetalle.bind();
        MTInventarioAmbiente mt = new MTInventarioAmbiente(listaAmbientesxInventario);
        tblAmbientesInventario.setModel(mt);
        tblAmbientesInventario.packAll();

    }

    private void bindeoSalvaje2() {
        listaBienes = new ArrayList();
        listaBienes = ObservableCollections.observableList(listaBienes);

        JTableBinding bindeoDetalle = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, listaBienes, tblInventario);

        BeanProperty bien = BeanProperty.create("bien");

        bindeoDetalle.addColumnBinding(bien).setColumnName("BIEN").setEditable(false);

        bindeoDetalle.bind();
    }

    private InventarioAmbienteControlador ic = new InventarioAmbienteControlador();

    private void cargarAmbientes(Inventario inventario) {

        List<InventarioAmbiente> listaIA = ic.buscarXInventario(inventario);

        listaAmbientesxInventario.clear();
        listaAmbientesxInventario.addAll(listaIA);

    }
    
    private void ExportarTXT(){
        if (this.tblInventario.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "TXT",
                    JOptionPane.INFORMATION_MESSAGE);
            this.btnExportar.grabFocus();
            return;
        }
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(tblInventario);
            nom.add("Reporte de bienes por ambiente");
            String texto = chooser.getSelectedFile().toString().concat(".txt");
            try {
                ExportadorTXT e = new ExportadorTXT(new File(texto), tb, nom, this.inventario.getFecha_inicio(), this.inventario.getFecha_fin(), false);
                if (e.exportarTXT()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a texto.", "TXT",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void ExportarXLS(){
        if (this.tblInventario.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "XLS",
                    JOptionPane.INFORMATION_MESSAGE);
            this.btnExportar.grabFocus();
            return;
        }
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(tblInventario);
            nom.add("Reporte de bienes por ambiente");
            String excel = chooser.getSelectedFile().toString().concat(".xls");
            try {
                Exportador e = new Exportador(new File(excel), tb, nom, this.inventario.getFecha_inicio(), this.inventario.getFecha_fin(), false);
                if (e.exportar()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "BCO",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
