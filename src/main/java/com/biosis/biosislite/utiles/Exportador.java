/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.utiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Boolean;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Documentos
 */
public class Exportador {

    private File archivo;
    private List<JTable> tabla;
    private List<String> nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean flag;

    public Exportador(File archivo, List<JTable> tabla, List<String> nombres, Date fecha_inicio, Date fecha_fin, boolean flag) throws Exception {
        this.archivo = archivo;
        this.tabla = tabla;
        this.nombre = nombres;
        this.fechaInicio = fecha_inicio;
        this.fechaFin = fecha_fin;
        this.flag = flag;

        if (nombres.size() != tabla.size()) {
            throw new Exception("Error");
        }
    }

    public boolean exportar() {

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(archivo));
            WritableWorkbook ex = Workbook.createWorkbook(out);

            WritableFont formatoHoja = new WritableFont(WritableFont.COURIER, 14);
            formatoHoja.setBoldStyle(WritableFont.BOLD);

            WritableCellFormat formato = new WritableCellFormat(formatoHoja);

            for (int index = 0; index < tabla.size(); index++) {
                JTable table = tabla.get(index);
                WritableSheet hoja = ex.createSheet(nombre.get(index), 0);

                hoja.addCell(new Label(0, 0, "Desde:", formato));
                hoja.addCell(new Label(0, 1, "Hasta:", formato));

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

                hoja.addCell(new Label(1, 0, formatoFecha.format(this.fechaInicio) + ""));
                hoja.addCell(new Label(1, 1, formatoFecha.format(this.fechaFin) + ""));

                //Para que salga el titulo de las columnas
                for (int i = 0; i < table.getColumnCount(); i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object titulo = table.getColumnName(i);
                        hoja.addCell(new Label(i, j + 3, String.valueOf(titulo), formato));
                    }
                }
                for (int i = 0; i < table.getColumnCount(); i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object contenido = table.getValueAt(j, i);

                        if (contenido == null) {
                            hoja.addCell(new Label(i, j + 4, " "));
                        } else {
                            if (i == 2 && this.flag == true) {
                                String valor = String.valueOf(contenido);
                                hoja.addCell(new Label(i, j + 4, valor.substring(valor.length()-10, valor.length())));
                            }else{
                                hoja.addCell(new Label(i, j + 4, String.valueOf(contenido)));
                            }
                            
                        }

                    }
                }

            }
            ex.write();
            ex.close();
            return true;
        } catch (IOException | WriteException e) {
            return false;
        }
    }
}
