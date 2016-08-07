/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.inventario;

import com.biosis.biosislite.entidades.inventario.Tipo;
import com.biosis.biosislite.controladores.inventario.AbstractControlador;
import com.biosis.biosislite.controladores.inventario.TipoControlador;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.beanutils.BeanUtils;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Documentos
 */
public class MantenimientoTipo extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoTipo
     */
    private static MantenimientoTipo instancia;

    public MantenimientoTipo() {
        initComponents();
        listar();
        FormularioUtil.activarComponente(panelDatos, false);
        FormularioUtil.activarComponente(panelOpciones, true);
        FormularioUtil.activarComponente(panelGuardar, false);
    }

    public static MantenimientoTipo getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoTipo();
        }
        return instancia;
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

        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltipo = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        panelOpciones = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        panelGuardar = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mantenimiento Tipo");
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 12, 0, 12, 0, 12, 0, 12, 0};
        getContentPane().setLayout(layout);

        jLabel1.setText("Buscar: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 397;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(txtbuscar, gridBagConstraints);

        jButton1.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton1, gridBagConstraints);

        jLabel2.setText("Lista de tipos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        tbltipo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbltipo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 525;
        gridBagConstraints.ipady = 106;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.1;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        panelDatos.setToolTipText("");
        panelDatos.setLayout(new java.awt.GridBagLayout());

        nombreLabel.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelDatos.add(nombreLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 261;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelDatos.add(nombreField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 160;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(panelDatos, gridBagConstraints);

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        panelOpciones.setToolTipText("");
        java.awt.GridBagLayout panelOpcionesLayout = new java.awt.GridBagLayout();
        panelOpcionesLayout.columnWidths = new int[] {0};
        panelOpcionesLayout.rowHeights = new int[] {0, 12, 0, 12, 0};
        panelOpciones.setLayout(panelOpcionesLayout);

        btnnuevo.setText("Nuevo");
        btnnuevo.setMaximumSize(new java.awt.Dimension(75, 23));
        btnnuevo.setMinimumSize(new java.awt.Dimension(75, 23));
        btnnuevo.setPreferredSize(new java.awt.Dimension(75, 23));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        panelOpciones.add(btnnuevo, gridBagConstraints);

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 3;
        panelOpciones.add(btnmodificar, gridBagConstraints);

        btneliminar.setText("Eliminar");
        btneliminar.setMaximumSize(new java.awt.Dimension(75, 23));
        btneliminar.setMinimumSize(new java.awt.Dimension(75, 23));
        btneliminar.setPreferredSize(new java.awt.Dimension(75, 23));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 3;
        panelOpciones.add(btneliminar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelOpciones, gridBagConstraints);

        panelGuardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelGuardar.setLayout(new java.awt.GridBagLayout());

        btnguardar.setText("Guardar");
        btnguardar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnguardar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnguardar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        panelGuardar.add(btnguardar, gridBagConstraints);

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 4;
        panelGuardar.add(btncancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelGuardar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        accion = AbstractControlador.NUEVO;
        tipoControlador.prepararCrear();
        FormularioUtil.activarComponente(panelOpciones, false);
        FormularioUtil.activarComponente(panelGuardar, true);
        FormularioUtil.activarComponente(panelDatos, true);
        nombreField.requestFocusInWindow();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
        accion = AbstractControlador.MODIFICAR;

        int fila = this.tbltipo.getSelectedRow();
        if (fila != -1) {
            FormularioUtil.activarComponente(panelDatos, true);
            FormularioUtil.activarComponente(panelOpciones, false);
            FormularioUtil.activarComponente(panelGuardar, true);

            accion = AbstractControlador.MODIFICAR;
            tipoControlador.setSeleccionado(lista.get(fila));
            Tipo tipo = tipoControlador.getSeleccionado();
            try {
                nombreField.setText(BeanUtils.getProperty(tipo, "nombre"));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                Logger.getLogger(MantenimientoClase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Tipo", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        accion = AbstractControlador.ELIMINAR;
        if (tbltipo.getSelectedRow() != -1) {

            Integer codigo = tbltipo.getSelectedRow();

            Tipo tipo = tipoControlador.buscarPorId(lista.get(codigo).getId());

            if (tipo != null) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Tipo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    int[] filas = tbltipo.getSelectedRows();
                    for (int i = 0; i < filas.length; i++) {
                        Tipo empleado2 = lista.get(filas[0]);
                        lista.remove(empleado2);
                        tipoControlador.setSeleccionado(empleado2);
                        tipoControlador.accion(accion);
                    }
                    if (tipoControlador.accion(accion) == 3) {
                        JOptionPane.showMessageDialog(null, "Tipo eliminado correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo no eliminada", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tipo no eliminada", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Tipo", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        List<Integer> array = new ArrayList();
        array.add(FormularioUtil.Validar(FormularioUtil.TipoValidacion.NUMERO, this.nombreField, "Nombre"));
        FormularioUtil.validar2(array);

        if (FormularioUtil.error) {
            JOptionPane.showMessageDialog(null, FormularioUtil.mensaje, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            FormularioUtil.mensaje = "";
            FormularioUtil.error = false;
        } else {
            String palabra = "";
            String palabra2 = "";
            if (accion == 1) {
                palabra = "registrar";
                palabra2 = "registrado";

                if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Tipo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    tipoControlador.getSeleccionado().setNombre(nombreField.getText().toUpperCase());

                    tipoControlador.accion(accion);
                    lista.add(tipoControlador.getSeleccionado());

                    if (accion == 1) {
                        JOptionPane.showMessageDialog(null, "Tipo " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        FormularioUtil.limpiarComponente(panelDatos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    FormularioUtil.limpiarComponente(panelDatos);
                    JOptionPane.showMessageDialog(null, "Tipo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else if (accion == 2) {
                palabra = "modificar";
                palabra2 = "modificado";

                if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Tipo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    if (accion == 2) {
                        JOptionPane.showMessageDialog(null, "Tipo " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                        lista.clear();
                        tipoControlador.getSeleccionado().setNombre(nombreField.getText().toUpperCase());
                        tipoControlador.accion(accion);
                        listar();

                        FormularioUtil.limpiarComponente(panelDatos);

                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    FormularioUtil.limpiarComponente(panelDatos);
                    JOptionPane.showMessageDialog(null, "Tipo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
            FormularioUtil.limpiarComponente(panelDatos);
            FormularioUtil.activarComponente(panelOpciones, true);
            FormularioUtil.activarComponente(panelGuardar, false);
            FormularioUtil.activarComponente(panelDatos, false);
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        FormularioUtil.activarComponente(panelDatos, false);
        FormularioUtil.limpiarComponente(panelDatos);
        FormularioUtil.activarComponente(panelOpciones, true);
        FormularioUtil.activarComponente(panelGuardar, false);
    }//GEN-LAST:event_btncancelarActionPerformed
    private int accion;
    private List<Tipo> lista;
    private final TipoControlador tipoControlador = new TipoControlador();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGuardar;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTable tbltipo;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    private void listar() {
        lista = tipoControlador.buscarTodos();
        lista = ObservableCollections.observableList(lista);
        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tbltipo);

        BeanProperty bId = BeanProperty.create("id");
        BeanProperty bNombre = BeanProperty.create("nombre");

        binding.addColumnBinding(bId).setColumnName("ID").setEditable(false);

        binding.addColumnBinding(bNombre).setColumnName("NOMBRE").setEditable(false);

        binding.bind();

    }
}
