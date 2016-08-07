/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.inventario;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import com.biosis.biosislite.controladores.inventario.AbstractControlador;
import java.util.List;

/**
 *
 * @author RyuujiMD
 */
public class FormularioUtil {

    private static final File CARPETA_IMG = new File("img/");
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";
    public static String mensaje = "";
    public static Boolean error = false;
    public static String msg = "";

    public enum TipoValidacion {

        NUMERO,
        LETRA
    }

    /*
     * Get the extension of a file.
     */
    public static boolean dialogoConfirmar(Component parent, int accion) {
        String mensaje = "";
        String titulo = "MENSAJE DEL SISTEMA";
        int tipoMensaje = 0;
        switch (accion) {
            case AbstractControlador.NUEVO:
                mensaje = "¿DESEA GUARDAR LA INFORMACIÓN?";
                tipoMensaje = JOptionPane.QUESTION_MESSAGE;
                break;
            case AbstractControlador.MODIFICAR:
                mensaje = "¿DESEA GUARDAR LOS CAMBIOS REALIZADOS?";
                tipoMensaje = JOptionPane.QUESTION_MESSAGE;
                break;
            case AbstractControlador.ELIMINAR:
                mensaje = "¿ESTA SEGURO QUE DESEA ELIMINAR LA INFORMACIÓN?";
                tipoMensaje = JOptionPane.WARNING_MESSAGE;
                break;
        }

        return JOptionPane.showConfirmDialog(parent, mensaje, titulo, JOptionPane.YES_NO_OPTION, tipoMensaje) == JOptionPane.YES_OPTION;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static String chooserImagen(Component component) {
        JFileChooser chooser = null;
        String ruta = "img/";
        if (chooser == null) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File(ruta));
        } else {
            chooser.setCurrentDirectory(chooser.getSelectedFile());
        }

        chooser.setDialogTitle("Seleccione un directorio");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(JOptionPane.getFrameForComponent(component)) == JFileChooser.APPROVE_OPTION) {
            File file = new File(chooser.getSelectedFile().getPath());
            if (file.exists()) {
                System.out.println("EXISTE");
            }
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
            return chooser.getSelectedFile().getPath();
        } else {
            System.out.println("No Selection ");
            return "";
        }

    }
    private static final Logger LOG = Logger.getLogger(FormularioUtil.class.getName());

    public static String guardarImagen(String origen) {
        if (CARPETA_IMG.exists()) {
            LOG.info("--- EXISTE LA CARPETA DE LA IMAGEN---");
        } else {
            LOG.warning("--- NO EXISTE LA CARPETA DE LA IMAGEN---");
            CARPETA_IMG.mkdir();
        }
        String imagen = "/" + CARPETA_IMG.listFiles().length;
        Path pOrigen = Paths.get(origen);
        Path pDestino = Paths.get(CARPETA_IMG.getAbsolutePath() + imagen);

        CopyOption[] opciones = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};

        try {
            Files.copy(pOrigen, pDestino, opciones);
        } catch (IOException ex) {
            Logger.getLogger(FormularioUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        String extension = getExtension(pOrigen.toFile());
        return "img" + imagen + extension;
    }

    public static void activarComponente(Component component, boolean editable) {
        if (component instanceof JDateChooser) {
            JDateChooser dc = (JDateChooser) component;
            activarComponente(dc.getCalendarButton(), editable);
            ((JTextFieldDateEditor) dc.getDateEditor()).setEditable(false);
        } else if (component instanceof JTextComponent) {
            ((JTextComponent) component).setEditable(editable);
        } else if (component instanceof AbstractButton) {
            component.setEnabled(editable);
        } else if (component instanceof JPanel) {
            for (Component c : ((JPanel) component).getComponents()) {
                activarComponente(c, editable);
            }
        } else {
            component.setEnabled(editable);
        }
    }

    public static void limpiarComponente(Component component) {
//        if (component instanceof JComboBox) {
//            ((JComboBox) component).setSelectedIndex(0);
//        } else 
            if (component instanceof JTextComponent) {
            ((JTextComponent) component).setText("");
        } else if (component instanceof JDateChooser) {
            ((JDateChooser) component).setDate(null);
        } else if (component instanceof JPanel) {
            for (Component c : ((JPanel) component).getComponents()) {
                limpiarComponente(c);
            }
        }

    }

    public static void convertirMayusculas(Component component) {
        if (component instanceof JTextComponent) {
            JTextComponent textoComponent = (JTextComponent) component;
            textoComponent.setText(textoComponent.getText().toUpperCase().trim());
        } else if (component instanceof JPanel) {
            for (Component c : ((JPanel) component).getComponents()) {
                convertirMayusculas(c);
            }
        }
    }

    public static Integer Validar(TipoValidacion tipo, Component component, String campo) {

        if (component instanceof JTextComponent) {
            JTextComponent texto = (JTextComponent) component;
            String cadena = texto.getText().toUpperCase();
            String comparacion = "";

            if (texto.getText().isEmpty()) {
                mensaje = mensaje + "El campo " + campo + " esta vacío \n";
                texto.setText(null);
                texto.requestFocusInWindow();
                return 0;
            } else {
                if (tipo == FormularioUtil.TipoValidacion.LETRA) {
                    comparacion = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
                } else if (tipo == TipoValidacion.NUMERO) {
                    comparacion = "1234567890.,";
                }
                Boolean bandera = false;

                for (int i = 0; i < cadena.length(); i++) {
                    for (int j = 0; j < comparacion.length(); j++) {
                        if (cadena.substring(i, i + 1).equals(comparacion.substring(j, j + 1))) {
                            bandera = true;
                        }
                    }
                }
                if (bandera == true) {
                    texto.setText(null);
                    texto.requestFocusInWindow();
                    if (tipo == FormularioUtil.TipoValidacion.LETRA) {
                        mensaje = mensaje + "El campo " + campo + " sólo admite números \n";
                        return 1;
                    } else {
                        mensaje = mensaje + "El campo " + campo + " sólo admite letras \n";
                        return 1;
                    }

                }
            }
        }
        return 5;
    }

    public static void validar2(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 0 || array.get(i) == 1) {
                error = true;
            }
        }
    }
}
